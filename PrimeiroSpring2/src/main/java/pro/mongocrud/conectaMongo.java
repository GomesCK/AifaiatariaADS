package pro.mongocrud;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;//add
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

public class conectaMongo {

    String database = "turmaB";
    String collection = "turmaB";

    public void getValues() {
        System.out.println("getValues");
        String uri = "mongodb://localhost";
        MongoClient mongo = MongoClients.create(uri);
        MongoDatabase db = mongo.getDatabase(database);

        MongoCollection<Document> docs = db.getCollection(collection);
        for (Document doc : docs.find()) {
            System.out.println("item: " + doc);
        }
        System.out.println("getValues ok");
    }

    public String selectValues(int x) {
        String y = "";
        System.out.println("Select Values");
        String uri = "mongodb://localhost";
        MongoClient mongo = MongoClients.create(uri);

        MongoDatabase db = mongo.getDatabase(database);
        MongoCollection<Document> docs = db.getCollection(collection);
        Document doc = docs.find(Filters.eq("_id", x)).first();
        y = doc.getString("nome");

        for (Document doc1 : docs.find()) {
            System.out.println("item2: " + doc1);
        }
        System.out.println("Select id ok");
        return y;
    }

    public void insertValues(String email, String senha) {
        System.out.println("insertValues");
        String uri = "mongodb://localhost";
        MongoClient mongo = MongoClients.create(uri);

        MongoDatabase db = mongo.getDatabase(database);
        MongoCollection<Document> docs = db.getCollection(collection);

        Document docBuilder = new Document();
        docBuilder.append("senha", senha);
        docBuilder.append("email", email);
        // docBuilder.append("profiss�o", profissao);
        docs.insertOne(docBuilder);//insere no mongo o conte�do de doc      
        System.out.println("insertValues ok");
    }

//    public boolean findValuesid(int id) {
//        boolean y = false;
//        System.out.println("findValues");
//        String uri = "mongodb://localhost";
//        MongoClient mongo = MongoClients.create(uri);
//
//        MongoDatabase db = mongo.getDatabase(database);
//        MongoCollection<Document> docs = db.getCollection(collection);
//
//        for (Document doc : docs.find(Filters.eq("_id", id))) {
//            System.out.println("achou pelo id: " + doc);
//            y = true;
//        }
//        System.out.println("findid() - finalizou");
//        return y;
//    }

    public boolean findValuesEmail(String email, String senha) {
        boolean x = false;
        boolean y = false;
        boolean z = false;
//        String email2 = "Email informado incorreto ou sem cadastro";
//        String senha1 = "Senha incorreta";
        System.out.println("findName");
        String uri = "mongodb://localhost";
        MongoClient mongo = MongoClients.create(uri);
        MongoDatabase db = mongo.getDatabase(database);
        MongoCollection<Document> docs = db.getCollection(collection);

        for (Document doc : docs.find(Filters.eq("email", email))) {
            System.out.println("achou pelo email: " + doc);
//            email2 = email;
        }
        for (Document doc : docs.find(Filters.eq("senha", senha))) {
            System.out.println("achou pela senha: " + doc);
//            senha1 = senha;
        }
        if(x && y){
            z = true;
        }else{
                System.out.println("Email ou senha incorreto!!");
                }
        System.out.println("findName() - finalizou");
        return z;
    }

    public void updateValues() {
        System.out.println("updateValues");
        String uri = "mongodb://localhost";
        MongoClient mongo = MongoClients.create(uri);

        MongoDatabase db = mongo.getDatabase(database);
        MongoCollection<Document> docs = db.getCollection(collection);

        docs.updateOne(Filters.eq("_id", 2),
                Updates.set("cidadenasc", "Santa Maria - RS"));
        System.out.println("Documento teve sucesso no update...");
        for (Document doc : docs.find()) {
            System.out.println("item update: " + doc);
        }
    }

    public void deleteValues() {
        System.out.println("deleteValues");
        String uri = "mongodb://localhost";
        MongoClient mongo = MongoClients.create(uri);

        MongoDatabase db = mongo.getDatabase(database);
        MongoCollection<Document> docs = db.getCollection(collection);

        docs.deleteOne(Filters.eq("_id", 4));
        System.out.println("Documento teve sucesso no delete...");
        for (Document doc : docs.find()) {
            System.out.println("item deleted: " + doc);
        }
    }
}
//public class conectaMongo {
//    public void getValues() {
//    System.out.println("M�todo getValues()");
//    MongoClient mongo = new MongoClient("localhost", 27017);
//    MongoDatabase db = mongo.getDatabase("turmaB");
//    MongoCollection<Document> docs = db.getCollection("turmaB");
//    for (Document doc : docs.find()) {
//        System.out.println("item: " + doc);
//    }
//    System.out.println("getValues() - ok - finalizou");
//   }     
//    
//   public void insertValues(String nome, String prof, int id, boolean trab) {
//        System.out.println("M�todo insertValues()");
//        //conex�o mongo
//        MongoClient mongo = new MongoClient("localhost", 27017);
//        MongoDatabase db = mongo.getDatabase("turmaB");
//        MongoCollection<Document> docs = db.getCollection("turmaB");
//        Entrada user = createUser(nome, prof, id, trab);
////cria um user obj da classe conectar, 
////chamando o m�todo createUser() - logo abaixo
//        Document doc = createDocument(user);
////cria um doc que referencia o conte�do de user do createDocument()
////obs, o Banco s� entende objetos do tipo Document, 
//        docs.insertOne(doc);//insere no mongo o conte�do de doc
//        getValues();
//        System.out.println("insertValues ok");
//    }
//
//   public Entrada createUser(String nome, String prof, int id, boolean trab) {
//        //esse m�todo deve ser uma entrada 
//        //externa (interface, scanner ou JOptionPanel
//        Entrada u = new Entrada();
//        u.setId(id);
//        u.setNome(nome);
//        u.setProfissao(prof);
//        u.setEsta_trabalhando(trab);
//        return u;
//    }
//
//   public Document createDocument(Entrada user) {
//        Document docBuilder = new Document();
//        docBuilder.append("_id", user.getId());
//        docBuilder.append("nome", user.getNome());
//        docBuilder.append("profissao", user.getProfissao());
//        docBuilder.append("esta_trabalhando", user.isEsta_trabalhando());
//        return docBuilder;
//    }
//
//   
//
//    public void updateValues() {
//
//        System.out.println("updateValues");
//        //Entrada user = createUser();
//        MongoClient mongo = new MongoClient("localhost", 27017);
//
//        MongoDatabase db = mongo.getDatabase("turmaB");
//        MongoCollection<Document> docs = db.getCollection("turmaB");
//
//        docs.updateOne(Filters.eq("nome", "Crishna"), Updates.set("cidadenasc", "Santa Maria - RS"));
//        System.out.println("Documento teve sucesso no update...");
//        for (Document doc : docs.find()) {
//            System.out.println("item update: " + doc);
//        }
//
//    }
//
//    public  void deleteValues() {
//        System.out.println("deleteValues");
//        //Entrada user = createUser();
//        MongoClient mongo = new MongoClient("localhost", 27017);
//
//        MongoDatabase db = mongo.getDatabase("turmaB");
//        MongoCollection<Document> docs = db.getCollection("turmaB");
//
//        docs.deleteOne(Filters.eq("nome", "Maria"));
//        System.out.println("Documento teve sucesso no delete...");
//        for (Document doc : docs.find()) {
//            System.out.println("item update: " + doc);
//        }
//
//    }
//}
