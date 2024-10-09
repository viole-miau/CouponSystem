package com.nya.mitzi.clr;

//@Component
//@Order(1)
public class Demo5 /*implements CommandLineRunner*/ {
//    @Autowired
//    private RestTemplate restTemplate;
//    @Autowired
//    private CategoryService categoryService;
//    public List<Category>categories4Test=new ArrayList<>();
//
//    @Override
//    public void run(String... args) {
//
//        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@"+'\n');
//
//        System.out.println("--------------------CATEGORY SERVICE");
//
//        System.out.println("--------------------1.is exist");
//
//        this.addCategories(0,10,false);
//
//        System.out.println("--------------------1.1.valid - exist"+'\n');
//
//        Category category0=this.categories4Test.get(0);
//        try {
//            this.categoryService.addCategory(category0);
//        }catch (CategoryException e){
//            e.printStackTrace();
//        }
//
//        System.out.println('\n'+"result: " + this.categoryService.isExist(category0) + '\n');
//
//
//        System.out.println("--------------------1.2.valid - not exist"+'\n');
//        Category category1= this.categories4Test.get(1);
//        category1.setName("category1-not exist");
//
//        System.out.println('\n'+"result: "+this.categoryService.isExist(category1)+'\n');
//
//
//        System.out.println("--------------------1.3.not valid - name empty"+'\n');
//        Category category2= this.categories4Test.get(2);
//        category2.setName("");
//
//        System.out.println('\n'+"result: "+this.categoryService.isExist(category2)+'\n');
//
//
//        System.out.println("--------------------1.4.not valid - name null"+'\n');
//
//        Category category3= this.categories4Test.get(3);
//        category3.setName(null);
//
//        System.out.println('\n'+"result: "+this.categoryService.isExist(category3)+'\n');
//
//
//        System.out.println("--------------------2.add");
//
//        this.addCategories(10,10,false);
//
//
//        System.out.println("--------------------2.1.valid"+'\n');
//
//        Category category10= this.categories4Test.get(10);
//
//        try {
//            this.categoryService.addCategory(category10);
//        }catch (CategoryException e) {
//            e.printStackTrace();
//        }
//
//
//        System.out.println("--------------------2.2.not valid - name not unique"+'\n');
//
//        Category category12= this.categories4Test.get(12);
//        category12.setName("category0");
//
//        try {
//            this.categoryService.addCategory(category12);
//        }catch (CategoryException e) {
//            e.printStackTrace();
//        }//todo fix
//
//
//        System.out.println("--------------------2.3.not valid - name null"+'\n');
//
//        Category category15= this.categories4Test.get(15);
//        category15.setName(null);
//
//        try {
//            this.categoryService.addCategory(category15);
//        }catch (CategoryException e) {
//            e.printStackTrace();
//        }//todo fix*//*
//
//
//        System.out.println("--------------------2.4.not valid - name empty"+'\n');
//
//        Category category18= this.categories4Test.get(18);
//        category18.setName("");
//
//        try {
//            this.categoryService.addCategory(category18);
//        }catch (CategoryException e) {
//            e.printStackTrace();
//        }//todo fix
//
//
//        System.out.println("--------------------3.update");
//
//        this.addCategories(20,10,true);
//
//
//        System.out.println("--------------------3.1.valid"+'\n');
//
//        Category category20= this.categories4Test.get(20);
//        category20.setName("category20-updated");
//
//        try {
//            this.categoryService.updateCategory(3,category20);
//        }catch (CategoryException e){
//            e.printStackTrace();
//        }
//
//
//        System.out.println("--------------------3.2.not valid - name not unique"+'\n');
//
//        Category category22=this.categories4Test.get(22);
//        category22.setName("category0");
//
//        try {
//            this.categoryService.updateCategory(5,category22);
//        }catch (CategoryException e){
//            e.printStackTrace();
//        }//todo fix
//
//
//        System.out.println("--------------------3.3.not valid - name null"+'\n');
//
//        Category category25=this.categories4Test.get(25);
//        category25.setName(null);
//
//        try {
//            this.categoryService.updateCategory(8,category25);
//        }catch (CategoryException e){
//            e.printStackTrace();
//        }//todo fix
//
//
//        System.out.println("--------------------3.4.not valid - name empty"+'\n');
//
//        Category category28=this.categories4Test.get(28);
//        category28.setName("");
//
//        try {
//            this.categoryService.updateCategory(8,category28);
//        }catch (CategoryException e){
//            e.printStackTrace();
//        }//todo fix
//
//
//        System.out.println("--------------------3.5.not valid - id not exist"+'\n');
//
//        Category category29=this.categories4Test.get(29);
//
//        try {
//            this.categoryService.updateCategory(20,category29);
//        }catch (CategoryException e){
//            e.printStackTrace();
//        }//todo fix
//
//
//        System.out.println("--------------------4.delete");
//        System.out.println("--------------------4.1. valid"+'\n');
//
//        try {
//            this.categoryService.deleteCategory(4);
//        }catch (CategoryException e){
//            e.printStackTrace();
//        }
//
//
//        System.out.println("--------------------4.2. not valid - id not exist"+'\n');
//        try {
//            this.categoryService.deleteCategory(20);
//        }catch (CategoryException e){
//            e.printStackTrace();
//        }
//
//
//        System.out.println("--------------------5.get one"+'\n');
//        System.out.println("--------------------5.1. valid"+'\n');
//
//        try {
//            System.out.println(this.categoryService.getCategory(1));
//        }catch (CategoryException e){
//            e.printStackTrace();
//        }
//
//
//        System.out.println("--------------------5.2. not valid"+'\n');
//
//        try {
//            System.out.println(this.categoryService.getCategory(20));
//        }catch (CategoryException e){
//            e.printStackTrace();
//        }
//
//        System.out.println("--------------------6.get all"+'\n');
//
//        System.out.println(this.categoryService.getCategoryList());
//    }
//    public void addCategories(int firstSerialNumber,int amount,boolean isAddToDb){
//        for (int i = firstSerialNumber; i <firstSerialNumber+amount ; i++) {
//            Category category=Category.builder()
//                    .name("category"+(i))
//                    .build();
//            if(isAddToDb) {
//                try {
//                    this.categoryService.addCategory(category);
//                } catch (CategoryException e) {
//                    e.printStackTrace();
//                }
//            }
//            this.categories4Test.add(category);
//        }
    //}
}
