import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBUpdate {

    private static final String POSTGRES_DRIVER = "org.postgresql.Driver";
    private static final String JDBC_CONNECTION = "jdbc:postgresql://localhost:5432/postgres"; // 問① ホスト名とデータベース名を設定
    private static final String USER = "postgres"; // 問② ユーザ名を設定
    private static final String PASS = "Ace71624"; // 問③ パスワードを設定

    public static void main(String[] args) {

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(POSTGRES_DRIVER);
            // 問④ 問①〜③の定数を使ってデータベースと接続
            connection = DriverManager.getConnection(
            	JDBC_CONNECTION, USER, PASS);
            statement = connection.createStatement();

            // 問⑤ SHOHIN_IDが020のSHOHIN_NAMEを「商品20」に変更するためのSQL文を記述
            String SQL = "UPDATE tb_shohin SET shohin_name = '商品20' WHERE shohin_id = '020'";

            // 問⑥ 上記のSQL文を実行するための文を記述
            int updatedRows = statement.executeUpdate(SQL);
            
            System.out.println("更新された行数: " + updatedRows);

            // 一覧表示
            String SQLselect = "SELECT * FROM tb_shohin";
            resultSet = statement.executeQuery(SQLselect);

            while (resultSet.next()) {
                String column1 = resultSet.getString("shohin_id");
                String column2 = resultSet.getString("shohin_name");
                int column3 = resultSet.getInt("tanka");

                System.out.print(column1 + ",");
                System.out.print(column2 + ",");
                System.out.println(column3);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}