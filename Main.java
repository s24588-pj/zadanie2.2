package pl.pjait;


import java.time.LocalDate;
import java.util.*;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {


        ArrayList<Cars> listOfOfferedCars = new ArrayList<Cars>();
        ArrayList<String> LiOfPublishedOffers = new ArrayList<String>();
        listOfOfferedCars.add(new Cars(10000, "toyota yaris", 2002, 200000, "2019 03 11"));
        listOfOfferedCars.add(new Cars(19000, "skoda fabia", 2005, 150000, "2020 05 23"));
        listOfOfferedCars.add(new Cars(25000, "skoda fabia", 2007, 175000, "2018 11 06"));
        listOfOfferedCars.add(new Cars(14000, "skoda octavia", 2002, 180000, "2018 04 30"));
        listOfOfferedCars.add(new Cars(30000, "honda civic", 2008, 100000, "2019 04 24"));
        listOfOfferedCars.add(new Cars(40000, "renault scenic", 2012, 50000, "2021 01 01"));
        listOfOfferedCars.add(new Cars(90000, "renault laguna", 2018, 25000, "2022 12 18"));

        List<Cars> Result = null; 

        for (Cars car : listOfOfferedCars) {
            System.out.println(car.toString());
        }
        System.out.println(" ");

        System.out.println("Wybierz opcję filtrowania: (numer)");
        System.out.println("1. Po cenie od do (należy podać przedział) ");
        System.out.println("2. Po nazwie (marka lub model)");
        System.out.println("3. Rocznik auta");
        System.out.println("4. Przebieg auta");
        System.out.println("5. Po dacie zamieszczenia oferty");

        Scanner sc = new Scanner(System.in);


        boolean reset;
        boolean otherReset;
        do {
            int option = sc.nextInt();
            reset = false;
            switch (option) {
                case 1:
                    System.out.println("Wybrałeś 1, podaj przedział cenowy: ");
                    int min = sc.nextInt();
                    int max = sc.nextInt();
                    Result = listOfOfferedCars.stream()
                            .filter(cars -> cars.getPrice() >= min && cars.getPrice() <= max)
                            .toList();
                    for (Cars cars : Result) {
                        System.out.println(cars.toString());
                    }
                    break;
                case 2:
                    System.out.println("Wybrałeś 2, podaj słowo kluczowe");
                    String title = sc.next();
                    Result = listOfOfferedCars.stream()
                            .filter(cars -> cars.getKeyword().contains(title))
                            .toList();
                    for (Cars cars : Result) {
                        System.out.println(cars.toString());
                    }
                    break;
                case 3:
                    System.out.println("Wybrałeś 3, podaj rocznik: ");
                    int year = sc.nextInt();
                    Result = listOfOfferedCars.stream()
                            .filter(cars -> cars.getYearOfProduction() == year)
                            .toList();
                    for (Cars cars : Result) {
                        System.out.println(cars.toString());
                    }
                    break;
                case 4:
                    System.out.println("Wybrałeś 4, podaj przedział przebiegu: ");
                    int minMileage = sc.nextInt();
                    int maxMileage = sc.nextInt();
                    Result = listOfOfferedCars.stream()
                            .filter(cars -> cars.getVehiMileage() >= minMileage && cars.getVehiMileage() <= maxMileage)
                            .toList();
                    for (Cars cars : Result) {
                        System.out.println(cars.toString());
                    }
                    break;
                case 5:
                    System.out.println("Wybrałeś 5, podaj datę ogłoszenia rrrr mm dd");
                    String yearOfOffer = sc.next();
                    Result = listOfOfferedCars.stream()
                            .filter(cars -> cars.getDateOfPublication().contains(yearOfOffer))
                            .toList();
                    for (Cars cars : Result) {
                        System.out.println(cars.toString());
                    }
                    break;
                default:
                    System.out.println("Nie poprawna opcja, wybierz z podanych!");
                    reset = true;
                    break;
            }
        } while (reset);
        System.out.println("Czy chcesz zobaczyć posortowane oferty? tak/nie");
        String t = sc.next();
        if (t.equals("tak")) {
            System.out.println("Jak chciałbyś posortować?");
            System.out.println("1. Po cenie");
            System.out.println("2. Po alfabetycznej kolejnosci ofert");
            System.out.println("3. Po roczniku");
            System.out.println("4. Po dacie zamieszczenia ogłoszenia");
            String d;
            do {
                int otherOption = sc.nextInt();
                otherReset = false;
                switch (otherOption) {
                    case 1:
                        System.out.println("Wybrałeś 1, sortujemy od największej(najw) czy najmniejszej(najm) ceny?");
                        d = sc.next();
                        if (d.equals("najw")) {
                            Collections.sort(listOfOfferedCars, new Comparator<Cars>() {
                                @Override
                                public int compare(Cars o1, Cars o2) {
                                    return o2.getPrice() - o1.getPrice();
                                }
                            });
                            for (Cars cars : listOfOfferedCars) {
                                System.out.println(cars.toString());
                            }
                            break;
                        } else {
                            Collections.sort(listOfOfferedCars, new Comparator<Cars>() {
                                @Override
                                public int compare(Cars o1, Cars o2) {
                                    return o1.getPrice() - o2.getPrice();
                                }
                            });
                            for (Cars cars : listOfOfferedCars) {
                                System.out.println(cars.toString());
                            }
                            break;
                        }
                    case 2:
                        System.out.println("Wybrałeś 2, sortujemy od a do z czy od z do a? a/z");
                        d = sc.next();
                        if (d.equals("a")) {
                            Collections.sort(listOfOfferedCars);
                            for (Cars cars : listOfOfferedCars) {
                                System.out.println(cars.toString());
                            }
                            break;
                        } else {
                            Collections.sort(listOfOfferedCars);
                            Collections.reverse(listOfOfferedCars);
                            for (Cars cars : listOfOfferedCars) {
                                System.out.println(cars.toString());
                            }
                            break;
                        }
                            case 3:
                                System.out.println("Wybrałeś 3, sortujemy od najstarszego(najs) czy najmłodszego(najm)?");
                                d = sc.next();
                                if (d.equals("najs")) {
                                    Collections.sort(listOfOfferedCars, new Comparator<Cars>() {
                                        @Override
                                        public int compare(Cars o1, Cars o2) {
                                            return o1.getYearOfProduction() - o2.getYearOfProduction();
                                        }
                                    });
                                    for (Cars cars : listOfOfferedCars) {
                                        System.out.println(cars.toString());
                                    }
                                    break;
                                } else {
                                    Collections.sort(listOfOfferedCars, new Comparator<Cars>() {
                                        @Override
                                        public int compare(Cars o1, Cars o2) {
                                            return o2.getYearOfProduction() - o1.getYearOfProduction();
                                        }
                                    });
                                    for (Cars cars : listOfOfferedCars) {
                                        System.out.println(cars.toString());
                                    }
                                }
                                break;
                            case 4:
                                System.out.println("Wybrałeś 4, sortujemy od najstarszego(najs) czy najmłodszego(najm)?");
                                d = sc.next();
                                if (d.equals("najs")) {
                                    Collections.sort(listOfOfferedCars);
                                    for (Cars cars : listOfOfferedCars) {
                                        System.out.println(cars.toString());
                                    }
                                    break;
                                } else {
                                    Collections.sort(listOfOfferedCars);
                                    Collections.reverse(listOfOfferedCars);
                                    for (Cars cars : listOfOfferedCars) {
                                        System.out.println(cars.toString());
                                    }
                                    break;
                                }
                            default:
                                System.out.println("Nie poprawna opcja, wybierz z podanych!");
                                otherReset = true;
                                break;
                        }
                }
                while (otherReset) ;
            }else;

        }

    }
