package cn.demo.easybuys.dao.impl;

import java.sql.*;

public class BaseDao {
    private final String DRIVER="com.mysql.jdbc.Driver";
    private final String URL="jdbc:mysql://127.0.0.1:3306/easybuy";
    private final String USERNAME="root";
    private final String USERPWD="990626";

    /**
     * 获取数据库链接
     * @return
     */
    public Connection getConnection(){
        Connection connection=null;
        try {
            Class.forName(DRIVER);
            connection= DriverManager.getConnection(URL,USERNAME,USERPWD);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 关闭所有链接
     * @param conn
     * @param ps
     * @param rs
     */
    public void closeAll(Connection conn, PreparedStatement ps, ResultSet rs){
        try {
            if (rs != null){
                rs.close();
            }
            if (ps != null){
                ps.close();
            }
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * 通用的执行方法(增删改)
     * @param
     * @param sql
     */
    public void execute(String sql,Object[] param){
        Connection connection=null;
        PreparedStatement ps=null;
        try {
            connection=getConnection();
            ps=connection.prepareStatement(sql);
            if (param != null && param.length > 0){
                for (int i=0;param.length > i;i++){
                    ps.setObject(i+1,param[i]);
                }
            }
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            closeAll(connection,ps,null);
        }
    }
}
