/*************************************
 * @author    Sabeeh Ahmad Ashir
 * @SID       230611665
 * @date      7 October 2024
 * @version   1
 *
 * Miniproject Level 06
 * A program that takes care of a mythical creature
 * and helps the caretaker survive.
 ****************************************/
import java.util.Scanner;

class Creature
    {
        String Name;
        int Anger_level;
        int Hunger_level;
        int Illness_level;
        String Favourite_food;
        int Magic_level;
        
    }
class Mythical_Creature
    {
        public static void main(String [] param) //main method of the program
        {
            Mythical_Creature_Care();
            return;
        }
       public static void Mythical_Creature_Care()//core of the program calling all other methods
        {
            final int NUM_OF_REORDS = 5;
            Creature [] creature_record = new Creature[NUM_OF_REORDS];
            
            String [] CreaturesName = {"Unicorn","Minautor","Centaur","Orthrus","Sphinx"};
            int [] HungerScores = {2,2,1,2,4};
            int [] AngerScores = {2,4,1,3,3};
            int [] illnesslevel = {2,2,3,4,3};
            int [] Magiclevel = {4,3,5,2,8};
            String []Favouritefood={"Mush","Meat","Nuts","Fish","Deer"};

            for (int i=0; i<NUM_OF_REORDS;i++)
            {
           
            creature_record[i]=Createrecord(CreaturesName[i],HungerScores[i],AngerScores[i],illnesslevel[i],Favouritefood[i],Magiclevel[i]);
    
            }
            Print("*******This program is to look after some mythical creatures that have been created********");
            
            Playgame(creature_record);
            return;
        
        }//Ends Mythical_Creature_Care
        
        public static void Print(String message)//Does the printing job
        {
            System.out.println(message);
    
            return;
            
        }//Ends Print
        
        public static int Get_Killer_Score(int [] hunger,int [] Anger, int [] illness,int index)//Getting the killerscore of the creature
        {
            
            int Killer=hunger[index]+Anger[index]+illness[index];
            return Killer;
            
        }//Ends Get_Killer_Score()
        
        public static void Danger_Message(int Killer_Score, String Name)//Displays the danger message for the user
        {
            if(Killer_Score <= 3) //uses IF else statements to make decisions.
                
            {
                Print("The " + Name + " is looking very Peacefull ");
                Print("You Survived this, Great job!!");
            }
            else if(Killer_Score >= 4 && Killer_Score <= 6)
            {
                Print("The " + Name + " is looking Miffed");
                Print("But you survived!!");
            }
            else if (Killer_Score >=7 && Killer_Score <= 9)
            {
                Print("The " + Name + " is still looking DANGEROUS !!!");
                Print("You are Dead!!");
            }
            else if (Killer_Score == 10 )
            {
                Print("The " + Name + " is Looking like its RABID... RUN!!!");
                Print("DEAD");
            }
            
            return;
            
        }//Ends DAnger_Message
        public static int GenerateRandomNumber() //Method to get the random number
        {
             Random stream_of_random_numbers = new Random();
                
             int random_number = stream_of_random_numbers.nextInt(5);
            
             return random_number;
        } // END generateRandomNumber
        
        public static void Playgame(Creature [] record) // Core method to allow User to take care of their creature
        {
            final int NUM_OF_ROUNDS=3;
            final int CHOICE_IN_EACH_ROUND=2;
            int Killer_Score;
            String User_Action="0";
            int index;
            Scanner input = new Scanner(System.in);
            boolean ValidInput;
            int Creature_to_change;
            
            
            for(int i=1; i<=NUM_OF_ROUNDS; i++) //loop for num of rounds
            {
                Print("\nRound >> " + i +" <<");         
                
                Print_Data(record);              

                for(int j = 1;  j<=CHOICE_IN_EACH_ROUND ;j++) //loop to move around for and choose any two creature in each round to take care of the creatures
                {
                    ValidInput=false;
                    Print("\nEnter the Creature number to help it survive");
                    Creature_to_change=Integer.parseInt(input.nextLine());
                    index=Creature_to_change-1;
                    Print("Creature "+j+" : "+ record[index].Name);
                    Print("Enter the action: Givewater, Givefood, Vaccinate, Moveit");

                    while (!ValidInput)
                    {
                    Print("Enter : ");
                    User_Action=input.nextLine();
                    ValidInput=CheckValid(User_Action);
                    }
            
                   Calculate_Score(User_Action,record,index);
                   Killer_Score=record[index].Hunger_level+record[index].Anger_level+record[index].Illness_level;
                   Danger_Message(Killer_Score,record[index].Name);
                    
                }
                
                
            }
                Print_Data(record);

        }//Ends Playgame
        
        public static void Calculate_Score(String Action, Creature [] current,int index) //Method to calculate the score 
        {
                if (Action.equals("Givewater"))
                    {
                       current[index].Hunger_level = current[index].Hunger_level-1;
                    }
                else if (Action.equals("Givefood"))
                    {
                        current[index].Hunger_level =  current[index].Hunger_level-2;
                    }
                else if (Action.equals("Vaccinate"))
                    {
                      current[index].Illness_level = current[index].Illness_level-3;
                    }  
                else if (Action.equals("Moveit"))
                    {
                        current[index].Anger_level = current[index].Anger_level-3;
                    }  
            return;
                
        } //Ends Calculate_score
        public static void Print_Data(Creature [] record) //Method to print data of creatures
        {
            int killerscore;
            int num=1;
            Print("\n*******************************************************************************************************");

            for(int i=0;i<5;i++)
                {
                    killerscore= record[i].Hunger_level + record[i].Anger_level + record[i].Illness_level;
                    Print("Creature "+num+" : " + record[i].Name + "      Hunger level: "+record[i].Hunger_level+"      Anger level :"+record[i].Anger_level+"     illness level "+record[i].Illness_level+"    Killer Score = "+ killerscore);
                    num++;
                }
            Print("*******************************************************************************************************");
            
            return;

        }//Ens Print_Data
        public static boolean CheckValid(String Action) //Method to check if the String is Valid or not
        {
            if (Action.equals("Givewater"))
                {
                   return true;
                }
            else if (Action.equals("Givefood"))
                {
                   return true;
                }
            else if (Action.equals("Vaccinate"))
                {
                   return true;
                }  
            else if (Action.equals("Moveit"))
                {
                   return true;
                }  
            Print("Invalid output!!!!!");
            return false;
        }//Ends CheckValid
        public static Creature Createrecord(String name, int hunger, int anger, int illness, String favfood, int magiclvl) //Method to Createrecord for Creatures
        {
            Creature current  = new Creature();
            
                current.Name=name;
                current.Hunger_level=hunger;
                current.Anger_level=anger;
                current.Illness_level=illness;
                current.Favourite_food=favfood;
                current.Magic_level=magiclvl;

            return current;
        } //Ends Createrecord
        
        
}

