package SqlPodklyuchenie;

public class SqlExecutor {

    private Connection connection;

    public SqlExecutor(Connection connection) {
        this.connection = connection;
    }
    public String dbSelectSq(String sql) {
        if (connection.getConnection()) {
            return "select" + sql;
        } else {
            return "error";
        }
    }
    public String dbUpdateSq(String sql) {
        if (connection.getConnection()) {
            return "update" + sql;
        } else {
            return "error";
        }
    }


}


