package jp.langstack;

import org.flywaydb.core.Flyway;

public class App {

    public static void main(String[] args) {
        // TODO：プロパティ外だし OR argsで渡すか
        String url = "jdbc:postgresql://localhost:5433/langstack";
        String user = "langstack";
        String password = "langstack";
        Flyway flyway = Flyway.configure().dataSource(url, user, password).load();
        flyway.migrate();
    }

}
