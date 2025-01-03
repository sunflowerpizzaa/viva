import java.util.Random;
import java.util.Arrays;


public class viva3q2 {
    public static void main(String[] args) {
        Hero amber = new Hero("Amber","Pyro",80.0);
        Hero kaeya = new Hero("Kaeya","Cyro",60.0);
        Hero lisa = new Hero("Lisa","Electro",100.0);
        Hero barbara = new Hero("Barbara","Hydro",40.0);
        
        Monster mitachurl = new Monster("Mitachurl",10,10,10,10,80.0);
        
        Hero[] heroList = {amber, kaeya, lisa, barbara};
        HeroParty party = new HeroParty(heroList);
        party.sortList();
        
        System.out.println("List of heroes based on power: ");
        for (Hero hero : heroList) {          //printing heroes according to the power order
            System.out.println(hero.name);
        }
        
        System.out.println("\nHeroes that will win against "+mitachurl.name+":");
        party.battleWinners(mitachurl);
        
        System.out.println();
        
        Monster cyroRegisvine = new Monster("Cyro Regisvine",20,20,20,40,200.0);
        party.battleBoss(cyroRegisvine);
    }
}
class Hero{
    String name;
    String element;
    double power;
    
    Hero(String name,String element,double power){
        this.name = name;
        this.element = element;
        this.power = power;
    }
}

class Monster{
    String name;
    int pyroR;
    int hydroR;
    int electroR;
    int cyroR;
    double HP;
    
    Monster(String name,int pyroR,int hydroR,int electroR,int cyroR,double HP){
        this.name = name;
        this.pyroR = pyroR;
        this.hydroR = hydroR;
        this.electroR = electroR;
        this.cyroR = cyroR;
        this.HP = HP;
    }
}

class HeroParty{
    Hero[] heroList;
    
    HeroParty(Hero[] heroList){
        this.heroList = heroList;
    }
    
    void sortList() {
    Arrays.sort(heroList, (hero1, hero2) -> Double.compare(hero2.power, hero1.power));//sorting the array of heroes according to power
    }
    
    void battleWinners(Monster monster){
        double resistance = 0;
        for(Hero hero: heroList){
            switch (hero.element) {
                case "Pyro":
                    resistance = monster.pyroR;
                    break;
                case "Cryo":
                    resistance = monster.cyroR;
                    break;
                case "Electro":
                    resistance = monster.electroR;
                    break;
                case "Hydro":
                    resistance = monster.hydroR;
                    break;
            }
            if((hero.power*((100-resistance)/100))>monster.HP){
                System.out.println(hero.name);
            }
        }
    }
    
    void battleBoss(Monster monster){
        String bestpair = null;
        double highestDamage = 0;
        double totalDamage=0;
        for(Hero hero1: heroList){
            for(Hero hero2:heroList){
                if(hero1!=hero2){
                    Random r = new Random();
                    //base resistance hero1
                    totalDamage = 0;
                    double resistance1 = 0;
                    switch (hero1.element) {
                        case "Pyro":
                            resistance1 = monster.pyroR;
                            break;
                        case "Cryo":
                            resistance1 = monster.cyroR;
                            break;
                        case "Electro":
                            resistance1 = monster.electroR;
                            break;
                        case "Hydro":
                            resistance1 = monster.hydroR;
                            break;
                        }
                    
                    //base resistance hero2
                    double resistance2 = 0;
                    switch (hero2.element) {
                        case "Pyro":
                            resistance2 = monster.pyroR;
                            break;
                        case "Cryo":
                            resistance2 = monster.cyroR;
                            break;
                        case "Electro":
                            resistance2 = monster.electroR;
                            break;
                        case "Hydro":
                            resistance2 = monster.hydroR;
                            break;
                        }
                    
                    //base power
                    double power1 = hero1.power;
                    double power2 = hero2.power;
                    
                    if ((hero1.element.equals("Pyro") && hero2.element.equals("Hydro")) ||
                        (hero1.element.equals("Hydro") && hero2.element.equals("Pyro"))) {
                    power1 += 1.5;
                    } 
                    else if ((hero1.element.equals("Pyro") && hero2.element.equals("Cryo")) ||
                           (hero1.element.equals("Cryo") && hero2.element.equals("Pyro"))) {
                    power1*=2;
                    }   
                    else if ((hero1.element.equals("Pyro") && hero2.element.equals("Electro")) ||
                           (hero1.element.equals("Electro") && hero2.element.equals("Pyro"))) {
                    totalDamage = r.nextInt(50,101);
                    } 
                    else if ((hero1.element.equals("Hydro") && hero2.element.equals("Electro")) ||
                           (hero1.element.equals("Electro") && hero2.element.equals("Hydro"))) {
                    totalDamage = r.nextInt(1,21);
                    } 
                    else if ((hero1.element.equals("Electro") && hero2.element.equals("Cryo")) ||
                           (hero1.element.equals("Cryo") && hero2.element.equals("Electro"))) {
                    resistance2 -=10;
                    }
                    
                    //final damage calculations
                    double damage1 = (power1*((100-resistance1)/100));
                    double damage2 = (power2*((100-resistance2)/100));
                   totalDamage += damage1 + damage2;
                    if(totalDamage>highestDamage){
                    bestpair = hero1.name + " and " + hero2.name;
                    highestDamage = totalDamage;
                    }
                }
            }
        }
        System.out.println("The pair with the highest damage: " + bestpair);
        System.out.println("Total damage dealt: " + highestDamage);
    }
}
