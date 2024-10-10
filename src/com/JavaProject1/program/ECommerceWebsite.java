package com.JavaProject1.program;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

 class colour {
    public static final String RESET = "\u001B[0m";  // Reset color
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";
}


 class Cart {

 
     private static HashMap<String, Integer> items = new HashMap<>();
     private static HashMap<String, Integer> itemPrices = new HashMap<>();
     private static HashMap<String, Integer> quantities = new HashMap<>();
     Scanner sc = new Scanner(System.in);

   
     public int AddCart(String item, int price) {
         if (items.containsKey(item)) {
             
             int currentQuantity = quantities.get(item);
             quantities.put(item, currentQuantity + 1);
             itemPrices.put(item, price * (currentQuantity + 1)); 
         } else {
             
             items.put(item, price);
             itemPrices.put(item, price);
             quantities.put(item, 1);
         }
         return 1;
     }

    
     void ViewCart() {
         if (items.isEmpty()) {
             System.out.println();
             System.out.println("_");
             System.out.println(colour.RED + "Your Cart is currently empty." + colour.RESET);
             System.out.println("_");
             ECommerceWebsite.menu();
         } else {
             System.out.println();
             System.out.println("---------- YOUR CART ----------");
             System.out.println("Item Name        Quantity   Price");
             System.out.println("---------------------------------");

             int totalAmount = 0;
             for (String item : items.keySet()) {
                 int quantity = quantities.get(item);
                 int price = itemPrices.get(item);
                 System.out.printf("%-15s %-10d ₹%-10d\n", item, quantity, price);
                 totalAmount += price;
             }
             System.out.println("---------------------------------");
             System.out.printf("%-15s %-10s ₹%-10d\n", "Total", "", totalAmount);
             System.out.println();

             
             modifyCartOptions();
         }
     }

    
     void modifyCartOptions() {
         System.out.println("1. Delete an Item");
         System.out.println("2. Back to Menu");
         System.out.print("Choose an option: ");
         int choice = sc.nextInt();

         if (choice == 1) {
             deleteItem();
         } else if (choice == 2) {
        	 ECommerceWebsite.menu();
         } else {
             System.out.println("Invalid choice, please try again.");
             modifyCartOptions();
         }
     }

     
     void deleteItem() {
         System.out.println();
         System.out.println("Enter the item name to delete: ");
         sc.nextLine();  
         String itemToRemove = sc.nextLine();

         if (items.containsKey(itemToRemove)) {
             items.remove(itemToRemove);
             itemPrices.remove(itemToRemove);
             quantities.remove(itemToRemove);
             System.out.println(colour.GREEN + itemToRemove + " has been removed from the cart." + colour.RESET);
         } else {
             System.out.println(colour.RED + "Item not found in the cart." + colour.RESET);
         }

         ViewCart();
     }
 }


class Electronics{
	ECommerceWebsite g=new ECommerceWebsite();
	Cart c=new Cart();
	Scanner sc=new Scanner(System.in);
	
	void mainItems() {
		System.out.println();
		System.out.println(colour.PURPLE+"-----AVAILABLE ELECTRONICS GADGETS-----"+colour.RESET);
		System.out.println(colour.YELLOW+"|-----------------------|");
		System.out.println("|1.| Mobile Phones      |");
		System.out.println("|2.| Televisions (Tv)   |");
		System.out.println("|3.| Earphones          |");
		System.out.println("|4.| Watches            |");
		System.out.println("|-----------------------|"+colour.RESET);
		System.out.println(" 5. View Cart");
		System.out.println(" 6. Back");
		
		
		LinkedHashMap<String, Integer> mobiles=new LinkedHashMap<String, Integer>();
		mobiles.put("Vivo T3", 20000);
		mobiles.put("IPhone 16", 120000);
		mobiles.put("OPPO C3", 16000);
		mobiles.put("Samsung", 160000);
		mobiles.put("Redmi Note 13 pro", 25000);
		mobiles.put("Realme 13", 35000);
		
		LinkedHashMap<String, Integer> television=new LinkedHashMap<String, Integer>();
		television.put("Motorola", 36000);
		television.put("Mi", 25000);
		television.put("TCL", 14000);
		television.put("Samsung", 26000);
		television.put("LG", 32000);
		television.put("Haier", 27000);
		
		LinkedHashMap<String, Integer> earphones=new LinkedHashMap<String, Integer>();
		earphones.put("boAt", 329);
		earphones.put("Zebronic", 59);
		earphones.put("Noise", 1499);
		earphones.put("Sounce", 209);
		earphones.put("Ambrane", 199);
		earphones.put("Boult", 349);
		
		LinkedHashMap<String, Integer> watches=new LinkedHashMap<String, Integer>();
		watches.put("Titan", 2575);
		watches.put("Hammmer", 1799);
		watches.put("Casio", 12995);
		watches.put("Timex", 10796);
		watches.put("Fossil", 8396);
		watches.put("Sonata", 1949);
		
		
		System.out.println();
		System.out.println("SELECT YOUR ELECTRONIC GADGET or OPTION:-");
		int item=sc.nextInt();
		if(item==1) {
			System.out.println(colour.BLUE+"------------------------------------------------");
			System.out.println("-----------------AVAILABLE ITEMS----------------");
			System.out.println("------------------------------------------------");
			int count=1;
			for (String product : mobiles.keySet()) {
	            System.out.println(count+". "+product +"        "+ " - ₹" + mobiles.get(product));
	            count++;
	        }
			System.out.println("------------------------------------------------"+colour.RESET);
			List<String> key = new ArrayList<>(mobiles.keySet());
			System.out.println("Select the Mobile which you Liked");
			int m=sc.nextInt();
			System.out.println();
			
			System.out.println("1. Want to add to Cart?");
			System.out.println("2.Back");
			System.out.println("Choose your option :");
			int ch=sc.nextInt();
			sc.nextLine();
			if(ch==1) {
				if(mobiles.containsKey(key.get(m-1))) {
					if(c.AddCart(key.get(m-1),mobiles.get(key.get(m-1)))==1) {
						System.out.println();
						System.out.println("");
						System.out.println(colour.GREEN+key.get(m-1)+" added to the Cart"+colour.RESET);
						System.out.println("");
						System.out.println();
						mainItems();
			
					}
					else {
						System.out.println("Unable to add the item to the Cart");
					}
				}
				else {
					System.out.println("Enter the item name correctly");
				}
			}
			else if(ch==2) {
				mainItems();
			}
			else {
				System.out.println("Enter Correct Choice..!");
			}
		}
			
		else if(item==2) {
			System.out.println(colour.BLUE+"------------------------------------------------");
			System.out.println("-----------------AVAILABLE ITEMS----------------");
			System.out.println("------------------------------------------------");
			int count=1;
			for (String tv : television.keySet()) {
	            System.out.println(count+". "+tv + " - ₹" + television.get(tv));
	            count++;
	        }
			System.out.println("------------------------------------------------"+colour.RESET);
			List<String> key = new ArrayList<>(television.keySet());
			System.out.println("Select the TV which you Liked");
			int m=sc.nextInt();
			System.out.println();
			System.out.println("1. Want to add to Cart?");
			System.out.println("2.Back");
			System.out.println("Choose your option :");
			int ch=sc.nextInt();
			sc.nextLine();
			if(ch==1) {
				if(television.containsKey(key.get(m-1))) {
					if(c.AddCart(key.get(m-1),television.get(key.get(m-1)))==1) {
						System.out.println();
						System.out.println("");
						System.out.println(colour.GREEN+key.get(m-1)+" added to the Cart"+colour.RESET);
						System.out.println("");
						System.out.println();
						mainItems();
			
					}
					else {
						System.out.println("Unable to add the item to the Cart");
					}
				}
				else {
					System.out.println("Enter the item name correctly");
				}
			}
			else if(ch==2) {
				mainItems();
			}
			else {
				System.out.println("Enter Correct Choice..!");
			}
		}
		
		
		else if(item==3) {
			System.out.println(colour.BLUE+"------------------------------------------------");
			System.out.println("-----------------AVAILABLE ITEMS----------------");
			System.out.println("------------------------------------------------");
			int count=1;
			for (String ear : earphones.keySet()) {
	            System.out.println(count+". "+ear + " - ₹" + earphones.get(ear));
	            count++;
	        }
			System.out.println("------------------------------------------------"+colour.RESET);
			List<String> key = new ArrayList<>(earphones.keySet());
			System.out.println("Select the Earphone which you Liked");
			int m=sc.nextInt();
			System.out.println();
			
			System.out.println("1. Want to add to Cart?");
			System.out.println("2.Back");
			System.out.println("Choose your option :");
			int ch=sc.nextInt();
			sc.nextLine();
			if(ch==1) {
				if(earphones.containsKey(key.get(m-1))) {
					if(c.AddCart(key.get(m-1),earphones.get(key.get(m-1)))==1) {
						System.out.println();
						System.out.println("");
						System.out.println(colour.GREEN+ key.get(m-1)+" added to the Cart"+colour.RESET);
						System.out.println("");
						System.out.println();
						mainItems();
			
					}
					else {
						System.out.println("Unable to add the item to the Cart");
					}
				}
				else {
					System.out.println("Enter the item name correctly");
				}
			}
			else if(ch==2) {
				mainItems();
			}
			else {
				System.out.println("Enter Correct Choice..!");
			}
		}
			
		
		else if(item==4) {
			System.out.println(colour.BLUE+"------------------------------------------------");
			System.out.println("-----------------AVAILABLE ITEMS----------------");
			System.out.println("------------------------------------------------");
			int count=1;
			for (String w : watches.keySet()) {
	            System.out.println(count+". "+w + " - ₹" + watches.get(w));
	            count++;
	        }
			System.out.println("------------------------------------------------"+colour.RESET);
			List<String> key = new ArrayList<>(watches.keySet());
			System.out.println("Select the Watch which you Liked");
			int m=sc.nextInt();
			
			System.out.println("1. Want to add to Cart?");
			System.out.println("2.Back");
			System.out.println("Choose your option :");
			int ch=sc.nextInt();
			sc.nextLine();
			if(ch==1) {
				if(watches.containsKey(key.get(m-1))) {
					if(c.AddCart(key.get(m-1),watches.get(key.get(m-1)))==1) {
						System.out.println();
						System.out.println("");
						System.out.println(colour.GREEN+ key.get(m-1)+" added to the Cart"+colour.RESET);
						System.out.println("");
						System.out.println();
						mainItems();
			
					}
					else {
						System.out.println("Unable to add the item to the Cart");
					}
				}
				else {
					System.out.println("Enter the item name correctly");
				}
			}
			else if(ch==2) {
				mainItems();
			}
			else {
				System.out.println("Enter Correct Choice..!");
			}
		}
			
		else if(item==5) {
			c.ViewCart();
		}
		else if(item==6) {
			ECommerceWebsite.menu();
		}
		
		
		else {
			System.out.println("Enter CORRECT Choice");
		}
	}
	
}

class Grocery{
	ECommerceWebsite g=new ECommerceWebsite();
	Cart c=new Cart();
	Scanner sc=new Scanner(System.in);
	void GoceryItems() {
		System.out.println();
		System.out.println(colour.PURPLE+"-----AVAILABLE GROCERY ITEMS-----"+colour.RESET);
		System.out.println(colour.YELLOW+"|-------------------|");
		System.out.println("|1.| Tea Powder     |");
		System.out.println("|2.| Dal            |");
		System.out.println("|3.| Cooking Oil    |");
		System.out.println("|4.| Rice           |");
		System.out.println("|-------------------|"+colour.RESET);
		System.out.println(" 5. View Cart");
		System.out.println(" 6. Back");
		
		LinkedHashMap<String, Integer> tea=new LinkedHashMap<String, Integer>();
		tea.put("Forest", 825);
		tea.put("Blue", 552);
		tea.put("Adbeni", 269);
		tea.put("TGL", 1043);
		tea.put("ISVARA", 413);
		tea.put("Rajaberi", 600);
		
		LinkedHashMap<String, Integer> dal=new LinkedHashMap<String, Integer>();
		dal.put("Chana", 193);
		dal.put("Tur", 225);
		dal.put("Red Masoor", 65);
		dal.put("Toor", 419);
		dal.put("Moong", 178);
		dal.put("Urad", 254);
		
		LinkedHashMap<String, Integer> oil=new LinkedHashMap<String, Integer>();
		oil.put("Sunpure", 245);
		oil.put("Aura", 274);
		oil.put("Gold Winner", 118);
		oil.put("Fortune", 119);
		oil.put("Saffola", 122);
		oil.put("Sunrich", 119);
		
		LinkedHashMap<String, Integer> rice=new LinkedHashMap<String, Integer>();
		rice.put("Daawat", 745);
		rice.put("India Gate", 345);
		rice.put("Devaaya", 348);
		rice.put("Fortune", 349);
		rice.put("GRM", 845);
		rice.put("Charminar", 299);
		
		
		
		System.out.println("SELECT YOUR GROCERY ITEM or OPTION :-");
		int item=sc.nextInt();
		if(item==1) {
			System.out.println(colour.BLUE+"------------------------------------------------");
			System.out.println("-----------------AVAILABLE ITEMS----------------");
			System.out.println("------------------------------------------------");
			int count=1;
			for (String product : tea.keySet()) {
	            System.out.println(count+". "+product +"        "+ " - ₹" + tea.get(product));
	            count++;
	        }
			System.out.println(colour.PURPLE+"NOTE : The above mentioned RATE is for 1kg Quantity"+colour.RESET);
			System.out.println("------------------------------------------------"+colour.RESET);
			List<String> key = new ArrayList<>(tea.keySet());
			System.out.println("Select the TEA Powder which you Liked");
			int m=sc.nextInt();
			System.out.println();
			
			System.out.println("1. Want to add to Cart?");
			System.out.println("2.Back");
			System.out.println("Choose your option :");
			int ch=sc.nextInt();
			sc.nextLine();
			if(ch==1) {
				if(tea.containsKey(key.get(m-1))) {
					if(c.AddCart(key.get(m-1),tea.get(key.get(m-1)))==1) {
						System.out.println();
						System.out.println("");
						System.out.println(colour.GREEN+key.get(m-1)+" added to the Cart"+colour.RESET);
						System.out.println("");
						System.out.println();
						GoceryItems();
			
					}
					else {
						System.out.println("Unable to add the item to the Cart");
					}
				}
				else {
					System.out.println("Enter the item name correctly");
				}
			}
			else if(ch==2) {
				GoceryItems();
			}
			else {
				System.out.println("Enter Correct Choice..!");
			}
		}
			
		else if(item==2) {
			System.out.println(colour.BLUE+"------------------------------------------------");
			System.out.println("-----------------AVAILABLE ITEMS----------------");
			System.out.println("------------------------------------------------");
			int count=1;
			for (String tv : dal.keySet()) {
	            System.out.println(count+". "+tv + " - ₹" + dal.get(tv));
	            count++;
	        }
			System.out.println(colour.PURPLE+"NOTE : The above mentioned RATE is for 1kg Quantity"+colour.RESET);
			System.out.println("------------------------------------------------"+colour.RESET);
			List<String> key = new ArrayList<>(dal.keySet());
			System.out.println("Select the DAL which you Liked");
			int m=sc.nextInt();
			System.out.println();
			System.out.println("1. Want to add to Cart?");
			System.out.println("2.Back");
			System.out.println("Choose your option :");
			int ch=sc.nextInt();
			sc.nextLine();
			if(ch==1) {
				if(dal.containsKey(key.get(m-1))) {
					if(c.AddCart(key.get(m-1),dal.get(key.get(m-1)))==1) {
						System.out.println();
						System.out.println("");
						System.out.println(colour.GREEN+key.get(m-1)+" added to the Cart"+colour.RESET);
						System.out.println("");
						System.out.println();
						GoceryItems();
			
					}
					else {
						System.out.println("Unable to add the item to the Cart");
					}
				}
				else {
					System.out.println("Enter the item name correctly");
				}
			}
			else if(ch==2) {
				GoceryItems();
			}
			else {
				System.out.println("Enter Correct Choice..!");
			}
		}
		
		
		else if(item==3) {
			System.out.println(colour.BLUE+"------------------------------------------------");
			System.out.println("-----------------AVAILABLE ITEMS----------------");
			System.out.println("------------------------------------------------");
			int count=1;
			for (String ear : oil.keySet()) {
	            System.out.println(count+". "+ear + " - ₹" + oil.get(ear));
	            count++;
	        }
			System.out.println(colour.PURPLE+"NOTE : The above mentioned RATE is for 1 litre Quantity"+colour.RESET);
			System.out.println("------------------------------------------------"+colour.RESET);
			List<String> key = new ArrayList<>(oil.keySet());
			System.out.println("Select the OIL which you Liked");
			int m=sc.nextInt();
			System.out.println();
			
			System.out.println("1. Want to add to Cart?");
			System.out.println("2.Back");
			System.out.println("Choose your option :");
			int ch=sc.nextInt();
			sc.nextLine();
			if(ch==1) {
				if(oil.containsKey(key.get(m-1))) {
					if(c.AddCart(key.get(m-1),oil.get(key.get(m-1)))==1) {
						System.out.println();
						System.out.println("");
						System.out.println(colour.GREEN+ key.get(m-1)+" added to the Cart"+colour.RESET);
						System.out.println("");
						System.out.println();
						GoceryItems();
			
					}
					else {
						System.out.println("Unable to add the item to the Cart");
					}
				}
				else {
					System.out.println("Enter the item name correctly");
				}
			}
			else if(ch==2) {
				GoceryItems();
			}
			else {
				System.out.println("Enter Correct Choice..!");
			}
		}
			
		
		else if(item==4) {
			System.out.println(colour.BLUE+"------------------------------------------------");
			System.out.println("-----------------AVAILABLE ITEMS----------------");
			System.out.println("------------------------------------------------");
			int count=1;
			for (String w : rice.keySet()) {
	            System.out.println(count+". "+w + " - ₹" + rice.get(w));
	            count++;
	        }
			System.out.println(colour.PURPLE+"NOTE : The above mentioned RATE is for 1kg Quantity"+colour.RESET);
			System.out.println("------------------------------------------------"+colour.RESET);
			List<String> key = new ArrayList<>(rice.keySet());
			System.out.println("Select the RICE which you Liked");
			int m=sc.nextInt();
			
			System.out.println("1. Want to add to Cart?");
			System.out.println("2.Back");
			System.out.println("Choose your option :");
			int ch=sc.nextInt();
			sc.nextLine();
			if(ch==1) {
				if(rice.containsKey(key.get(m-1))) {
					if(c.AddCart(key.get(m-1),rice.get(key.get(m-1)))==1) {
						System.out.println();
						System.out.println("");
						System.out.println(colour.GREEN+ key.get(m-1)+" added to the Cart"+colour.RESET);
						System.out.println("");
						System.out.println();
						GoceryItems();
			
					}
					else {
						System.out.println("Unable to add the item to the Cart");
					}
				}
				else {
					System.out.println("Enter the item name correctly");
				}
			}
			else if(ch==2) {
				GoceryItems();
			}
			else {
				System.out.println("Enter Correct Choice..!");
			}
		}
			
		else if(item==5) {
			c.ViewCart();
		}
		else if(item==6) {
			ECommerceWebsite.menu();
		}
		
		
		else {
			System.out.println("Enter CORRECT Choice");
		}
	}
}



class Fashion {
	ECommerceWebsite g = new ECommerceWebsite();
    Cart c = new Cart();
    Scanner sc = new Scanner(System.in);

    // Size mapping for easy display
    private static final Map<Integer, String> sizeMap = new HashMap<>();
    static {
        sizeMap.put(1, "S");
        sizeMap.put(2, "M");
        sizeMap.put(3, "L");
        sizeMap.put(4, "XL");
        sizeMap.put(5, "XXL");
    }

    void FashionItems() {
        System.out.println();
        System.out.println(colour.YELLOW + "-----AVAILABLE CLOTHES-----" + colour.RESET);
        System.out.println(colour.YELLOW + "|-----------------------|" + colour.RESET);
        System.out.println(colour.BLUE + "|1.| Men                |" + colour.RESET);
        System.out.println(colour.RED + "|2.| Women              |" + colour.RESET);
        System.out.println(colour.CYAN + "|3.| Kids               |" + colour.RESET);
        System.out.println(colour.YELLOW + "|-----------------------|" + colour.RESET);
        System.out.println(" 4. View Cart");
        System.out.println(" 5. Back");

        // Define clothing items for Men, Women, and Kids
        LinkedHashMap<String, Integer> menShirts = new LinkedHashMap<>();
        menShirts.put("Roadster - Black", 662);
        menShirts.put("Peter - White", 1119);
        menShirts.put("Roadster - Red", 1057);
        menShirts.put("SHOWOFF - Printed", 976);
        menShirts.put("Locomotive - Pink", 1799);
        menShirts.put("Mufti - Casual", 987);

        LinkedHashMap<String, Integer> menPants = new LinkedHashMap<>();
        menPants.put("Formal", 1932);
        menPants.put("Jaguar", 1225);
        menPants.put("Night Pant", 596);
        menPants.put("Jeans", 1419);

        LinkedHashMap<String, Integer> menTshirts = new LinkedHashMap<>();
        menTshirts.put("Oversized", 845);
        menTshirts.put("Formal", 274);
        menTshirts.put("Casual", 318);
        menTshirts.put("Round Neck", 219);
        menTshirts.put("Jacky", 922);

        LinkedHashMap<String, Integer> womenDresses = new LinkedHashMap<>();
        womenDresses.put("Zara - Red Dress", 1599);
        womenDresses.put("Mango - Floral", 1899);
        womenDresses.put("H&M - Casual", 1299);
        womenDresses.put("Gucci - Black Dress", 2999);

        LinkedHashMap<String, Integer> womenTops = new LinkedHashMap<>();
        womenTops.put("Forever 21 - Blue", 845);
        womenTops.put("Vero Moda - White", 274);
        womenTops.put("Levi's - Casual", 699);
        womenTops.put("Roadster - Pink", 499);

        LinkedHashMap<String, Integer> kidsClothes = new LinkedHashMap<>();
        kidsClothes.put("Disney - Mickey T-shirt", 345);
        kidsClothes.put("Puma - Sporty Shorts", 245);
        kidsClothes.put("Ben 10 - Cartoon Shirt", 199);
        kidsClothes.put("Frozen - Elsa Dress", 499);

        System.out.println("SELECT YOUR OPTION :-");
        int category = sc.nextInt();

        switch (category) {
            case 1:
                handleClothingSelection("Men", menShirts, menPants, menTshirts);
                break;
            case 2:
                handleClothingSelection("Women", womenDresses, womenTops, null);
                break;
            case 3:
                handleClothingSelection("Kids", kidsClothes, null, null);
                break;
            case 4:
                c.ViewCart();
                break;
            case 5:
            	ECommerceWebsite.menu();
                break;
            default:
                System.out.println("Enter CORRECT Choice");
                FashionItems();
        }
    }

    void handleClothingSelection(String category, LinkedHashMap<String, Integer> type1, LinkedHashMap<String, Integer> type2, LinkedHashMap<String, Integer> type3) {
        System.out.println(colour.BLUE + "------------------------------------------------");
        System.out.println("-----------AVAILABLE " + category.toUpperCase() + " CLOTHES-----------");
        System.out.println("------------------------------------------------" + colour.RESET);

        if (type1 != null) {
            System.out.println("|1.| Type 1: " + (category.equals("Men") ? "Shirts" : "Dresses") + "    |");
        }
        if (type2 != null) {
            System.out.println("|2.| Type 2: " + (category.equals("Men") ? "Pants" : "Tops") + "      |");
        }
        if (type3 != null) {
            System.out.println("|3.| Type 3: T-shirts       |");
        }
        System.out.println("----------------------------");
        System.out.println();
        System.out.println("Select the type of clothing you want:");
        int clothingType = sc.nextInt();

        LinkedHashMap<String, Integer> selectedItems = null;
        switch (clothingType) {
            case 1:
                selectedItems = type1;
                break;
            case 2:
                selectedItems = type2;
                break;
            case 3:
                selectedItems = type3;
                break;
            default:
                System.out.println("Enter correct choice");
                FashionItems();
                return;
        }

        // Handle size selection and display items with correct size
        if (selectedItems != null) {
            System.out.println("Available sizes are :");
            System.out.println("------------------------");
            System.out.println("|1. | S  |\n"
                    + "|2. | M  |\n"
                    + "|3. | L  |\n"
                    + "|4. | XL |\n"
                    + "|5. | XXL |");
            System.out.println("------------------------");
            System.out.println("Enter the Size Required :");
            int sizeOption = sc.nextInt();
            String selectedSize = sizeMap.getOrDefault(sizeOption, "Unknown");

            int count = 1;
            for (String product : selectedItems.keySet()) {
                System.out.println(count + ". " + product + " (" + selectedSize + ") " + " - ₹" + selectedItems.get(product));
                count++;
            }

            List<String> key = new ArrayList<>(selectedItems.keySet());
            System.out.println("Select the item which you liked:");
            int selectedItem = sc.nextInt();

            System.out.println();
            System.out.println("1. Want to add to Cart?");
            System.out.println("2. Back");
            System.out.println("Choose your option:");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                if (selectedItems.containsKey(key.get(selectedItem - 1))) {
                    if (c.AddCart(key.get(selectedItem - 1) + " (" + selectedSize + ")", selectedItems.get(key.get(selectedItem - 1))) == 1) {
                        System.out.println();
                        System.out.println("");
                        System.out.println(colour.GREEN + key.get(selectedItem - 1) + " (" + selectedSize + ") added to the Cart" + colour.RESET);
                        System.out.println("");
                        System.out.println();
                        FashionItems();
                    } else {
                        System.out.println("Unable to add the item to the Cart");
                    }
                } else {
                    System.out.println("Enter the item name correctly");
                }
            } else if (choice == 2) {
                FashionItems();
            } else {
                System.out.println("Enter Correct Choice..!");
                FashionItems();
            }
        }
    }
}



public class ECommerceWebsite{
	static Scanner sc=new Scanner(System.in);
	static Electronics e=new Electronics();
	static Grocery g=new Grocery();
	static Fashion f=new Fashion();
	public static void menu() {
		
		System.out.println(colour.CYAN+"\nMENU");
		System.out.println("1. Electronics");
		System.out.println("2. Grocery Items");
		System.out.println("3. Fashion"+colour.RESET);
		System.out.println();
		System.out.println("SELECT YOUR OPTION :-");
		int op=sc.nextInt();
		if(op==1) {
			e.mainItems();
		
		}
		else if(op==2) {
			g.GoceryItems();
		}
		else if(op==3) {
			f.FashionItems();
		}
	}
	public static void main(String[] args) {
		System.out.println("Welcome, Hurry up YOUR Shoping...");
		menu();
		
	}

}
