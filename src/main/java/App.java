import com.datastax.driver.core.Cluster;
import com.datastax.driver.core.Session;

public class App {

    public static void main(String[] args) {
        //create the local cluster instance
        Cluster cluster= Cluster.builder().addContactPoint("127.0.0.1").build();
        //connect to the local cluster
        Session session = cluster.connect();//here, could set keyspace name
        //create a new keyspace tp
        String query="CREATE KEYSPACE tp WITH REPLICATION = { 'class' : 'SimpleStrategy', 'replication_factor' : 1 }; ";
        session.execute(query);
        //close the session
        session.close();
    }

}
