public class PartThree {
    // תכנון REST API לספריה

    // ניצור DTOs למערכת ספריה
    // - מייצג ספרBookDTO
    public class bookDTO {
        public int id; // * שדה חובה
        public String title; // * שדה חובה
        public int authorId; // * שדה חובה
        public String authorName; // * שדה חובה
        public String kategory; // * שדה חובה
        public boolean isAvailable; // * שדה חובה
        public int shelfNumber; // * שדה חובה
        public int publishedYear;
    }
    // AuthorDTO - מייצג מחבר
    public class authorDTO {
        public int id;// * שדה חובה
        public String name;// * שדה חובה
    }
    // KategoryDTO - מייצג קטגורית ספר
    public class kategoryDTO {
        public int id;// * שדה חובה
        public String name;// * שדה חובה
    }
    // CustomerDTO - מייצג חבר ספריה
    public class customerDTO {
        public int id;// * שדה חובה
        public String name;// * שדה חובה
        public String email;// * שדה חובה
        public String phoneNumber;// * שדה חובה
        public String address;
        public bookDTO[] borrowedBooks;//* שדה חובה
    }
    
    //פעולות ה endPoints למערכת ספריה

    // Books    
        // GET /books - לקבלת רשימת כל הספרים
        // GET /books/{id} - לקבלת פרטי ספר לפי מזהה
        // GET /books/author/{authorId} - לקבלת כל הספרים של מחבר מסוים
        // GET /books/kategory/{kategoryId} - לקבלת כל הספרים בקטגוריה מסוימת
        // GET /books/available - לקבלת כל הספרים הזמינים להשאלה
        // GET /books/shelf/{shelfNumber} - לקבלת כל הספרים על מדף מסוים
        // POST /books - להוספת ספר חדש
        // PUT /books/{id} - לעדכון פרטי ספר קיים
        // DELETE /books/{id} - למחיקת ספר מרשימת הספרים

    // Authors
        // GET /authors - לקבלת רשימת כל המחברים
        // GET /authors/{id} - לקבלת פרטי מחבר לפי מזהה
        // POST /authors - להוספת מחבר חדש 
        // PUT /authors/{id} - לעדכון פרטי מחבר קיים
        // DELETE /authors/{id} - למחיקת מחבר מרשימת המחברים

    // Kategories    
        // GET /kategories - לקבלת רשימת כל הקטגוריות
        // GET /kategories/{id} - לקבלת פרטי קטגוריה לפי מזהה
        // POST /kategories - להוספת קטגוריה חדשה
        // PUT /kategories/{id} - לעדכון פרטי קטגוריה קיימת
        // DELETE /kategories/{id} - למחיקת קטגוריה מרשימת הקטגוריות

    // Customers
        // GET /customers - לקבלת רשימת כל לקוחות הספריה
        // GET /customers/{id} - לקבלת פרטי לקוח לפי מזהה
        // GET /customers/borrowedBooks/{bookId} - לקבלת כל הלקוחות שהשאלו ספר מסוים
        // POST /customers - להוספת לקוח ספריה חדש
        // PUT /customers/{id} - לעדכון פרטי לקול ספריה קיים
        // DELETE /customers/{id} - למחיקת לקוח ספריה מרשימת הלקוחות

//--------------------------------------------

    // מערכת הזמנות+תשלומים
    public class items { // מחלקה זו מייצגת פריט במערכת ההזמנות
        public int idItem;
        public String name;
        public String description;
        public double price;
        public int quantity;
        public String color;
        public String category;
    }

    public class orders { // מחלקה זו מייצגת הזמנה במערכת ההזמנות
        public int idOrder;
        public int idCustomer;
        public String status;
        public items[] itemsList;
        public double totalPrice;
    }

    public class customre { // מחלקה זו מייצגת לקוח במערכת ההזמנות
        public int idCustomer;
        public String name;
        public String email;
        public String phone;
        public String address;
    }

    public class payments { // מחלקה זו מייצגת תשלום במערכת ההזמנות
        public int idPayment;
        public int idOrder; // מזהה ההזמנה שאליה שייך התשלום
        public String paymentMethod;
        public String customerAddress;
        public double amount;
    }

}