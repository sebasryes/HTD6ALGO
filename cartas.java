import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

/**
 *
 * @author Sebastián Reyes 21139
 */
public class cartas {

    public static void main(String[] args) {
    
        int opcion = 0;
        int Tipomapa;
        
         
        Scanner read = new Scanner(System.in);
   
        
        Map<String, String> Totalcartas;
         Map<String, String> cartas1;
         
        
         MapFactory factory = new MapFactory();
         ArrayList<String> Nombrecarta = new ArrayList<String>();
         ArrayList<String> caract = new ArrayList<String>();
         ArrayList<String> Nombrecartausuario = new ArrayList<String>();
        

        ArrayList<String> allCards = new ArrayList<String>();
        try{
            Stream<String> lines = Files.lines(Paths.get("cards_desc.txt"),StandardCharsets.UTF_8);
            lines.forEach(a -> allCards.add(a));
        }catch(IOException e){
            System.out.println("Error al leer archivo");
        }
        
        
        System.out.println("Ingrese el tipo de mapa que desea utilizar: "
            + "\n1. HashMap"
            + "\n2. TreeMap"
            + "\n3. LinkedHashMap");
        
        Tipomapa = read.nextInt();
        
        //Si la opcion es mayor a 3 el programa lanza una advertencia 
        if (Tipomapa >= 4){
            System.out.println("Opcion incorrecta ");
            System.exit(0);
        }
        
    
        cartas1 = factory.ChooseMap(Tipomapa);
        Totalcartas = factory.ChooseMap(Tipomapa);
        
        
        for (String i: allCards) {
	                String[] information = i.split("[|]");
	                Nombrecarta.add(information[0]);
	                Totalcartas.put(information[0], information[1]);
                        
	    }
        
        
        
        while(opcion != 7){
            System.out.println("Seleccione la opcion que desea realizar: "
            + "\n1. Agregar una carta a tu coleccion"
            + "\n2. Mostrar el tipo de una carta"
            + "\n3. Mostrar informacion de las cartas de tu mazo"
            + "\n4. Mostrar informacion de las cartas de tu mazo ordenadas por tipo"
            + "\n5. Mostrar informacion de todas las cartas existentes"
            + "\n6. Mostrar informacion de todas las cartas existentes ordenadas por tipo"
            + "\n7. Salir" );
                        
             opcion = read.nextInt();
                    
            switch(opcion){
                
                case 1:
                    String name;
                    System.out.println("Ingrese la carta que desea agregar: ");
                    read.nextLine();
                    name = read.nextLine();
                    if (Totalcartas.containsKey(name) == true){
                        caract.add(name);
                        String newCard = Totalcartas.get(name);
                        Totalcartas.remove(name);
                        cartas1.put(name, newCard);
                        Nombrecartausuario.add(name);
                        System.out.println(name + " se ha agregado a tu mazo.");
                    }else{
                        System.out.println("La carta no existe");
                    }
                    break;
                
                case 2:
                    String name2;
                    System.out.println("Ingrese el nombre de la carta para saber de que tipo es: ");
                    read.nextLine();
                    name2 = read.nextLine();
                    System.out.println(name2 + " es del tipo:" + Totalcartas.get(name2));
                    break;

                case 3:
                    int cantMonster = 0;
                    int cantTrap = 0;
                    int cantSpells = 0;

                    
                    cartas1.forEach((nameC,type) -> System.out.println(nameC + " - " + type));

                    
                    for (int item = 0; item < cartas1.size(); item++){
                        if (cartas1.get(Nombrecartausuario.get(item)).equals("Monstruo")){
                            cantMonster +=1;      
                        }else if(cartas1.get(Totalcartas.get(Nombrecartausuario.get(item))).equals("Hechizo")){
                            cantTrap +=1;
                        }else if(cartas1.get(Totalcartas.get(Nombrecartausuario.get(item))).equals("Trampa")){
                            cantSpells +=1;
                        }
                    }
                   
                    System.out.println("Este es tu mazo "
                        + "\nMonstruos: " + cantMonster
                        + "\nHechizos: " + cantTrap
                        + "\nTrampas: " + cantSpells);
                    break;
                    
                case 4:
                    System.out.println("Huevos de acero");
                    String monsterPlayer = " ";
                    String trapPlayer = " "; 
                    String spellPlayer = " ";

                    
                    for (int i = 0; i < cartas1.size(); i++){
                        String nameAllPlayer = Nombrecartausuario.get(i);
                        String typePlayer = cartas1.get(nameAllPlayer);

                    switch (typePlayer) {
                        case "Monstruo":
                            monsterPlayer = monsterPlayer + "\n" + nameAllPlayer + " (Monstruo)";
                            break;
                        case "Trampa":
                            trapPlayer = trapPlayer + "\n" + nameAllPlayer + " (Trampa)";
                            break;
                        case "Hechizo":
                            spellPlayer = spellPlayer + "\n" + nameAllPlayer + " (Hechizo)";
                            break;
                        }   
                    }
                    System.out.println(monsterPlayer + trapPlayer + spellPlayer);
                    break;

                case 5:
                    
                    for (String ab : allCards) {
                        System.out.println(ab);
                    }
                    break;

                case 6:

                String hechizo = " ";  
                String mounstro = " ";
                String trampa = " "; 
                

                    
                    for (int i = 0; i < Nombrecarta.size(); i++){
                        String nameAll = Nombrecarta.get(i);
                        String type = Totalcartas.get(nameAll);

                    switch (type) {
                        case "Monstruo":
                            mounstro = mounstro + "\n" + nameAll + " (Monstruo)";
                            break;
                        case "Trampa":
                            trampa = trampa + "\n" + nameAll + " (Trampa)";
                            break;
                        case "Hechizo":
                            hechizo = hechizo + "\n" + nameAll + " (Hechizo)";
                            break;
                        default:
                            break;
                        }
                    }
                    System.out.println(mounstro + trampa + hechizo);
            }
            
        }
        
        
    }
    
}

