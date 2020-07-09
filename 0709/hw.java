package demo01;

import util.DatabaseType;
import util.JdbcHelper;

import java.io.*;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class hw {
    /**获取表中字段名称*/
    public  String[] getName(ResultSetMetaData data) throws SQLException {
        int count = data.getColumnCount();
        String[] filedname= new String[count];
        for (int i = 0; i <count; i++) {
            filedname[i]=data.getColumnName(i+1);
        }
        return filedname;
    }
    /**获得表中字段数据类型*/
    public String getType(String type) {
        // 暂且先把数据库的配置信息用 字符串字面量 直接设置
        switch( type ) {
            case "INT" :
                return "int";
            case "DATE" :
                return "LocalDate";
            case "CHAR" :
                return "Char";
            case "VARCHAR" :
                return "String";
            default :
                throw new RuntimeException( "暂不支持该数据库" );
        }
    }
    public static void main(String[] args) throws SQLException, IOException {
        hw test = new hw();
        JdbcHelper h = JdbcHelper.getInstance(DatabaseType.MYSQL);
        Scanner in = new Scanner(System.in);
        System.out.println("请输入需要生成代码的表：");
        String form = in.next();
        String sql = "SELECT * from " +form;
        ResultSet resultSet = h.create().executeQuery(sql);
        ResultSetMetaData data = resultSet.getMetaData();
        StringBuffer buffer =new StringBuffer();
        String form1 = form.substring(0,1).toUpperCase()+form.substring(1);
        buffer.append("public class" +" "+ form +"{ \n");
        String[] filedname = test.getName(data);
        for (int i = 0; i < data.getColumnCount(); i++) {
            buffer.append("\t private " +test.getType(data.getColumnTypeName(i+1)) +"\t"+filedname[i]  +";"+"\n");
        }
        for (int i=0;i<data.getColumnCount();i++){
            String tmp =filedname[i].substring(0,1).toUpperCase()+filedname[i].substring(1);
            buffer.append("\t public " +test.getType(data.getColumnTypeName(i+1)) + " get" +tmp +"(){\n");
            buffer.append("\t \t return this." + filedname[i] +"; \n }\n");
            buffer.append("\t public void set"  +tmp +"( " +test.getType(data.getColumnTypeName(i+1))+" " +filedname[i]+ "){\n");
            buffer.append("\t \t this." + filedname[i] +" = " + filedname[i] +"; \n }\n");
        }
        File file = new File(form+".java");
        OutputStream out =new FileOutputStream(file);
        out.write(buffer.toString().getBytes());

    }
}
