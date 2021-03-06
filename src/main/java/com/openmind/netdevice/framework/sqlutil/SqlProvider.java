package com.openmind.netdevice.framework.sqlutil;

import com.openmind.netdevice.framework.model.Identity;
import com.openmind.netdevice.framework.util.ArrayUtils;
import org.apache.log4j.Logger;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


/**
 * This class is used to create the sql string according to parameters of each function.
 * Only for mysql at present.There may be some problems when using other databases.
 * Created by LiuBin on 2017/6/22.
 * <p>
 * TODO 以后改进用map包装参数传入， 就可以附带各种其他参数了。select方面还需要再改进。 目前主键id 没有用到 需要完善 one2many many2one
 */
public class SqlProvider {

    Logger logger = Logger.getLogger(SqlProvider.class);
    private TableFormat tableFormat = new HumpToUnderLineFormat();

    public String insert(Object bean) {
        Class<?> beanClass = bean.getClass();
        String tableName = getTableName(beanClass);
        boolean autoIncre = isKeyAutoIncre(beanClass);
        Field[] fields = getFields(beanClass);
        StringBuilder insertSql = new StringBuilder();
        //mybatis 的参数化表示  #{xxx}
        List<String> insertParas = new ArrayList<String>();
        //字段名
        List<String> insertParaNames = new ArrayList<String>();
        insertSql.append("INSERT INTO ").append(tableName).append("(");
        try {
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                Column column = field.getAnnotation(Column.class);
                String columnName = "";
                if (column != null) {
                    if (!column.required())
                        continue;
                    columnName = column.value();
                }
                if (StringUtils.isEmpty(columnName)) {
                    columnName = tableFormat.getColumnName(field.getName());
                }
                field.setAccessible(true);
                Object object = field.get(bean);
                if (object != null) {
                    insertParaNames.add(columnName);
                    insertParas.add("#{" + field.getName() + "}");
                }
            }
            if (!autoIncre) {
                insertParaNames.add(getIdentity().getName());
                insertParas.add(IdWorker.getId()+"");
            }
        } catch (Exception e) {

            new RuntimeException("get insert sql  exceptoin:" + e);
        }
        for (int i = 0; i < insertParaNames.size(); i++) {
            insertSql.append(insertParaNames.get(i));
            if (i != insertParaNames.size() - 1)
                insertSql.append(",");
        }
        insertSql.append(")").append(" VALUES(");
        for (int i = 0; i < insertParas.size(); i++) {
            insertSql.append(insertParas.get(i));
            if (i != insertParas.size() - 1)
                insertSql.append(",");
        }
        insertSql.append(")");
        logger.info("##insert sql##:" + insertSql.toString());
        return insertSql.toString();
    }

    public String insertBatch(Map map) {
        List<Object> list = (List<Object>) map.get("list");
        list.getClass().getTypeParameters();
        Class<?> beanClass = list.get(0).getClass();
        String tableName = getTableName(beanClass);
        Field[] fields = getFields(beanClass);
        StringBuilder insertSql = new StringBuilder();
        List<String> insertParas = new ArrayList<>();
        List<String> insertParaNames = new ArrayList<>();
        MessageFormat mf;//= new MessageFormat("(null, #'{'list[{0}].name})");
        StringBuilder formatString = new StringBuilder();
        insertSql.append("insert into ").append(tableName).append(" ( ");

        try {
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                Column column = field.getAnnotation(Column.class);
                String columnName = "";
                if (column != null) {
                    if (!column.required())
                        continue;
                    columnName = column.value();
                }
                if (StringUtils.isEmpty(columnName)) {
                    columnName = tableFormat.getColumnName(field.getName());
                }
                insertParaNames.add(columnName);
                insertParas.add(field.getName());
            }


            //(columnname1,columnname2.......)
            formatString.append(" ( ");
            for (int i = 0; i < insertParaNames.size(); i++) {
                insertSql.append(insertParaNames.get(i));
                //此处单引号是为了  messageFormat 中保留 {  }
                formatString.append("#'{'list[{0}].").append(insertParas.get(i)).append("'}' ");
                if (i != insertParaNames.size() - 1) {
                    insertSql.append(",");
                    formatString.append(",");
                }
            }
            formatString.append(" ) ");
            insertSql.append(" ) ").append(" values ");
            //formatString (list[{0}].x,list[{0}].y...)
            mf = new MessageFormat(formatString.toString());
            for (int i = 0; i < list.size(); i++) {
                insertSql.append(mf.format(new Object[]{i}));
                if (i < list.size() - 1)
                    insertSql.append(",");
            }

            //insertSql.append(formatString);
        } catch (Exception e) {
            new RuntimeException("get [batch] insert sql exceptoin:" + e);
        }
        logger.info("##[batch] insert sql##:" + insertSql.toString());
        return insertSql.toString();
    }

    public String update(Object bean) {
        Class<?> beanClass = bean.getClass();
        String tableName = getTableName(beanClass);
        Field[] fields = getFields(beanClass);
        StringBuilder updateSql = new StringBuilder();
        List<String> updateParaNames = new ArrayList<>();
        List<String> updateParas = new ArrayList<>();
        updateSql.append(" update ").append(tableName).append(" set ");
        try {
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                Column column = field.getAnnotation(Column.class);
                String columnName = "";
                if (column != null) {
                    if (!column.required())
                        continue;
                    columnName = column.value();
                    if (StringUtils.isEmpty(columnName)) {
                        columnName = tableFormat.getColumnName(field.getName());
                    }
                }
                field.setAccessible(true);
                Object object = field.get(bean);
                if (object != null) {
                    if (!(object instanceof Long) || (object instanceof Long && 0 < (Long) object)) {
                        updateParaNames.add(columnName);
                        updateParas.add("#{" + field.getName() + "}");
                    }
                }
            }
        } catch (Exception e) {
            new RuntimeException("get update sql is exceptoin:" + e);
        }
        for (int i = 0; i < updateParaNames.size(); i++) {
            updateSql.append(updateParaNames.get(i)).append("=").append(updateParas.get(i));
            if (i != updateParaNames.size() - 1) {
                updateSql.append(",");
            }
        }
        updateSql.append(" where ").append(tableFormat.getId() + " =#{id}");
        logger.info("##update sql##:" + updateSql.toString());
        return updateSql.toString();
    }

    public String delete(Object bean) {
        Class<?> beanClass = bean.getClass();
        String tableName = getTableName(beanClass);
        Field[] fields = getFields(beanClass);
        StringBuilder deleteSql = new StringBuilder();
        List<String> deleteParaNames = new ArrayList<>();
        List<String> deleteParas = new ArrayList<>();
        deleteSql.append(" delete from ").append(tableName).append(" where  ");
        try {
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                Column column = field.getAnnotation(Column.class);
                String columnName = "";
                if (column != null) {
                    if (!column.required())
                        continue;
                    columnName = column.value();
                    if (StringUtils.isEmpty(columnName)) {
                        columnName = tableFormat.getColumnName(field.getName());
                    }
                    field.setAccessible(true);
                    Object object = field.get(bean);
                    if (object != null) {
                        if (!(object instanceof Long) || (object instanceof Long && 0 < (Long) object)) {
                            deleteParaNames.add(columnName);
                            deleteParas.add("#{" + field.getName() + "}");
                        }
                    }
                }
            }
        } catch (Exception e) {
            new RuntimeException("get delete sql is exceptoin:" + e);
        }
        if (deleteParaNames.size() < 1) {
            logger.error("SqlProvider.delete:There must be at least one sql parameter! class:[" + beanClass.getSimpleName() + "]");
            throw new RuntimeException("SqlProvider.delete:There must be at least one sql parameter! class:[" + beanClass.getSimpleName() + "]");
        }
        for (int i = 0; i < deleteParaNames.size(); i++) {
            deleteSql.append(deleteParaNames.get(i)).append("=").append(deleteParas.get(i));
            if (i != deleteParaNames.size() - 1) {
                deleteSql.append(",");
            }
        }
        logger.info("##delete sql##:" + deleteSql.toString());
        return deleteSql.toString();
    }

    public String select(Object bean) {
        Class<?> beanClass = bean.getClass();
        String tableName = getTableName(beanClass);
        Field[] fields = getFields(beanClass);
        StringBuilder selectSql = new StringBuilder();
        List<String> selectParaNames = new ArrayList<String>();
        List<String> selectParas = new ArrayList<String>();
        selectSql.append("select ");
        try {
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                Column column = field.getAnnotation(Column.class);
                String columnName = "";
                if (column != null) {
                    if (!column.required())
                        continue;
                    columnName = column.value();
                    if (StringUtils.isEmpty(columnName)) {
                        columnName = tableFormat.getColumnName(field.getName());
                    }
                    field.setAccessible(true);
                    Object object = field.get(bean);
                    selectSql.append(field.getName());
                    if (object != null) {
                        selectParaNames.add(columnName);
                        selectParas.add("#{" + field.getName() + "}");
                    }
                    if (i != fields.length - 1)
                        selectSql.append(",");
                }
            }
        } catch (Exception e) {
            new RuntimeException("get select sql is exceptoin:" + e);
        }
        selectSql.append(" from ").append(tableName);
        //如果bean的字段值都是空的，代表全查
        //用fuzzyselect 替代
        if (selectParaNames.size() > 0)
            selectSql.append(" where ");
        else {
            logger.error("SqlProvider.select:There must be at least one sql parameter! class:[" + beanClass.getSimpleName() + "]");
            throw new RuntimeException("SqlProvider.select:There must be at least one sql parameter! class:[" + beanClass.getSimpleName() + "]");
        }
        for (int i = 0; i < selectParaNames.size(); i++) {
            selectSql.append(selectParaNames.get(i)).append("=").append(selectParas.get(i));
            if (i != selectParaNames.size() - 1)
                selectSql.append(" and ");
        }
        logger.info("##select sql##:" + selectSql.toString());
        return selectSql.toString();
    }

    public String fuzzySelect(Object bean) {
        Class<?> beanClass = bean.getClass();
        String tableName = getTableName(beanClass);
        Field[] fields = getFields(beanClass);
        StringBuilder selectSql = new StringBuilder();
        List<String> selectParaNames = new ArrayList<String>();
        List<String> selectParas = new ArrayList<String>();
        selectSql.append("select ");
        try {
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                Column column = field.getAnnotation(Column.class);
                String columnName = "";
                if (column != null) {
                    if (!column.required())
                        continue;
                    columnName = column.value();
                    if (StringUtils.isEmpty(columnName)) {
                        columnName = tableFormat.getColumnName(field.getName());
                    }
                    field.setAccessible(true);
                    Object object = field.get(bean);
                    selectSql.append(field.getName());
                    if (object != null) {
                        if (!(object instanceof Long) || (object instanceof Long && 0 < (Long) object)) {
                            selectParaNames.add(columnName);
                            selectParas.add("#{" + field.getName() + "}");
                        }
                    }
                    if (i != fields.length - 1)
                        selectSql.append(",");
                }
            }
        } catch (Exception e) {
            new RuntimeException("get fuzzy select sql is exceptoin:" + e);
        }
        selectSql.append(" from ").append(tableName);
        if (selectParaNames.size() > 0)
            selectSql.append(" where ");
        for (int i = 0; i < selectParaNames.size(); i++) {
            selectSql.append(selectParaNames.get(i)).append(" like  CONCAT(CONCAT('%', ").append(selectParas.get(i)).append("), '%')  ");
            if (i != selectParaNames.size() - 1)
                selectSql.append(" and ");
        }
        logger.info("##fuzzy select sql##:" + selectSql.toString());
        return selectSql.toString();
    }

    public String selectCount(Object bean) {
        Class<?> beanClass = bean.getClass();
        String tableName = getTableName(beanClass);
        Field[] fields = getFields(beanClass);
        StringBuilder selectSql = new StringBuilder();
        List<String> selectParaNames = new ArrayList<>();
        List<String> selectParas = new ArrayList<>();
        selectSql.append("select count(1) ");
        try {
            for (int i = 0; i < fields.length; i++) {
                Field field = fields[i];
                Column column = field.getAnnotation(Column.class);
                String columnName = "";
                if (column != null) {
                    if (!column.required())
                        continue;
                    columnName = column.value();
                    if (StringUtils.isEmpty(columnName)) {
                        columnName = tableFormat.getColumnName(field.getName());
                    }
                    field.setAccessible(true);
                    Object object = field.get(bean);
                    selectSql.append(field.getName());
                    if (object != null) {
                        selectParaNames.add(columnName);
                        selectParas.add("#{" + field.getName() + "}");
                    }
                    if (i != fields.length - 1)
                        selectSql.append(",");
                }
            }
        } catch (Exception e) {
            new RuntimeException("get select count sql is exceptoin:" + e);
        }
        selectSql.append(" from ").append(tableName);
        if (selectParaNames.size() > 0)
            selectSql.append(" where ");
        for (int i = 0; i < selectParaNames.size(); i++) {
            selectSql.append(selectParaNames.get(i)).append(" like  CONCAT(CONCAT('%', ").append(selectParas.get(i)).append("), '%')  ");
            if (i != selectParaNames.size() - 1)
                selectSql.append(" and ");
        }
        logger.info("##select count sql##" + selectSql.toString());
        return selectSql.toString();
    }

    //TODO selectByCond
    public String selectByPage(Map map) {
        Object bean = map.get("obj");
        Page page = (Page) map.get("page");

        return null;
    }

    //TODO updateByCond
    public String updateByCond(Map map) {
        return null;
    }

    private boolean isKeyAutoIncre(Class<?> beanClass) {
        boolean f;
        Table table = beanClass.getAnnotation(Table.class);
        f = table.keyAutoIncrese();
        return f;
    }

    private String getTableName(Class<?> beanClass) {
        String tableName = "";
        Table table = beanClass.getAnnotation(Table.class);
        if (table != null) {
            tableName = table.value();
        } else {
            tableName = tableFormat.getTableName(beanClass.getSimpleName());
        }
        return tableName;
    }

    private Field[] getFields(Class<?> beanClass) {
        Field[] re;
        Field[] beanFields = beanClass.getDeclaredFields();
        re = beanFields;
        Class<?> beanSuperClass = beanClass.getSuperclass();
        while (!beanSuperClass.getTypeName().equals("java.lang.Object")) {
            Field[] beanSuperFields = beanSuperClass.getDeclaredFields();
            re = ArrayUtils.addAll(re, beanSuperFields);
            beanSuperClass = beanSuperClass.getSuperclass();
        }
        return re;
    }

    private Field getIdentity(){
        return getFields(Identity.class)[0];
    }
}