import java.sql.*;

/**
 * Created by Administrator on 2018/5/8.
 */
public class JDBC
{
    public static void main(String[] args)
    {
        //1.加载数据库驱动到内存
        
        
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
        //2.获取数据库连接
        Connection conn = null;
        PreparedStatement ps = null;
        try
        {
           conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/neuedu", "root", "root");
            System.out.println(conn);
        //3.创建PreparedStatement
            ps = conn.prepareStatement("INSERT into sorder values (null,?,?,?,?,?,?,?,?)");
        //4.替换？号，执行sql语句
            ps.setInt(1,1);
            ps.setString(2,"openid");
            ps.setDouble(3,100.32);
            ps.setString(4,null);
            ps.setDouble(5,123.83);
            ps.setString(6,"A");
            //java.sql.date()没有时分秒 java.util.date()有时分秒
            //时间原点 1970年1月1日 0点0分0秒 当前时间距离原点走过的毫秒数 System.currentTimeMillis()用这个方法取
            Timestamp now = new Timestamp(System.currentTimeMillis());
            ps.setTimestamp(7,now);
            ps.setInt(8,1);
            //执行sql语句
            ps.executeUpdate();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        finally
        {
        //关闭连接
            try
            {
                ps.close();
                conn.close();
            } catch (SQLException e)
            {
                e.printStackTrace();
            }

        }
    }
}
