package Shop;

public class User {
    String login;
    String password;
    Bucket bucket;

    public User(String login, String password, Bucket bucket) {
        this.login = login;
        this.password = password;
        this.bucket = bucket;
    }

    public void Add(Product product) {
        bucket.Add(product);
    }

    public Product RemoveIndex(int index){
        return bucket.RemoveIndex(index);
    }
}
