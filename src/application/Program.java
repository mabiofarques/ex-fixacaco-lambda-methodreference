package application;

import entities.Employees;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        System.out.print("Enter full file path: ");
        String path = sc.nextLine();

        System.out.print("Enter salary: ");
        double typedSalary = sc.nextDouble();
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {

            List<Employees> list = new ArrayList<>();

            String line = br.readLine();
            while (line != null) {
                String[] fields = line.split(",");
                String name = fields[0];
                String email = fields[1];
                double salary = Double.parseDouble(fields[2]);
                list.add(new Employees(name, email, salary));
                line = br.readLine();
            }

            List<Employees> emp = list.stream().filter(p -> p.getSalary() > typedSalary)
                    .sorted(Comparator.comparing(Employees::getEmail)).toList();

            System.out.println("Email of people whose salary is more than: " + String.format("%.2f", typedSalary));
            for (Employees e : emp) {
                System.out.println(e.getEmail());
            }

            double empSumChar = list.stream().filter(e -> e.getName().charAt(0) == 'M')
                    .map(Employees::getSalary).reduce(0.0,(x, y) -> x + y);

            System.out.println("Sum of salary of people whose name starts with 'M': " + String.format("%.2f", empSumChar));

        }
        catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            sc.close();
        }
    }
}
