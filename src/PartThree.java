public class PartThree {

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