import java.util.*;

class Student{
    private String id,name;
    private int marks;
    public Student(){
        this.id="";
        this.name="";
        this.marks=0;
    }
    public Student(String id, String name, int marks){
        this.id=id;
        this.name=name;
        this.marks=marks;
    }
    public String getId(){return id;}
    public int getMarks() {return marks;}
    public String getRole(){return "undergrad"; }
    @Override
    public String toString(){
        return id+" "+name+" ( "+marks+" ) "+getRole();
    }
}



class GraduateStudent extends Student{
    private String area;
    public GraduateStudent(String id, String name, int marks, String area){
        super(id,name,marks);
        this.area=area;
    }
    @Override
    public String getRole(){
        return "Grad ( "+area+" ) ";
    }
}

class Repository<T>{ //custom generic
    private Map<String,T> data = new HashMap<>();
    public void save(String id, T obj){data.put(id,obj);}
    public T find(String id){return data.get(id);}
    public void delete(String id){data.remove(id);}
}

public class wwc {
    public static void main(String[] args){
        List<Student> list = new ArrayList();
        list.add(new Student("s1","Gunjan",95));
        list.add(new Student("s2","Himanshi",95));
        list.add(new Student("s3","Payal",79));
        list.add(new GraduateStudent("g1","Karishma",98,"BE-CSE"));
        Repository<Student> repo = new Repository<>();
        for(Student s : list) repo.save(s.getId(),s);
        System.out.println("ALL: ");
        list.forEach(System.out::println);
        System.out.println("\nLOOKUP S2: ");
        Student s = repo.find("s2");
        System.out.println(s!=null ? s : " Not Found");

        Iterator<Student> it = list.iterator();
        while(it.hasNext()){
            Student st = it.next();
            if(st.getMarks()<80){
                it.remove();
                repo.delete(st.getId());
            }
        }
        System.out.println("\nAFTER REMOVAL: ");
        list.forEach(System.out::println);
    }

}

    
