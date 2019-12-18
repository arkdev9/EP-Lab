import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Scanner;

public class Main {
    private static SessionFactory sessionFactory;

    public static void main(final String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        sessionFactory = new Configuration().configure().addAnnotatedClass(Student.class).buildSessionFactory();
        String choice = "yes";
        listStudents();
        while (choice.equals("yes") || choice.equals("y")) {
            printMenu();
            choice = scanner.nextLine();
            switch (choice) {
                case "1":
                    System.out.println("Enter student details on separate lines (roll number, name, batch, branch)");
                    Integer rollNumber = scanner.nextInt();
                    scanner.nextLine();
                    String name = scanner.nextLine();
                    Integer batch = scanner.nextInt();
                    scanner.nextLine();
                    String branch = scanner.nextLine();
                    Student newStudent = new Student(rollNumber, name, branch, batch);
                    addStudent(newStudent);
                    break;
                case "2":
                    System.out.println("Enter the roll number of student to be deleted");
                    Integer roll = scanner.nextInt();
                    scanner.nextLine();
                    deleteStudent(roll);
                    break;
                case "4":
                    listStudents();
                    break;
                default:
                    System.out.println("Sorry invalid choice.");
            }
            System.out.println("Do you want to continue?");
            choice = scanner.nextLine();
        }
        sessionFactory.close();
    }

    public static void addStudent(Student student) {
        Session sess = sessionFactory.openSession();
        Transaction tx = sess.getTransaction();
        try {
            tx.begin();
            Integer id = (Integer) sess.save(student);
            tx.commit();
            System.out.println("Added " + id);
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            sess.close();
        }
    }

    public static void deleteStudent(Integer rollNumber) {
        Session sess = sessionFactory.openSession();
        Transaction tx = sess.getTransaction();
        try {
            tx.begin();
            Query query = sess.createQuery("delete from Student s where s.rollNumber=?1");
            query.setParameter(1, rollNumber);
            query.executeUpdate();
            tx.commit();
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            sess.close();
        }
    }

    public static void listStudents() {
        Session sess = sessionFactory.openSession();
        Transaction tx = sess.getTransaction();
        try {
            tx.begin();
            Query query = sess.createQuery("from Student");
            List<Student> results = query.list();
            tx.commit();
            for (Student student : results) {
                System.out.println(student.getRollNumber() + "\t" + student.getName() + "\t" + student.getBatch() +
                        "\t" + student.getBranch());
            }
        } catch (HibernateException e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        } finally {
            sess.close();
        }
    }

    private static void printMenu() {
        System.out.println("1. Add student to database");
        System.out.println("2. Delete student from database");
        System.out.println("3. Modify a student's details in database");
        System.out.println("4. List student details in database");
    }
}