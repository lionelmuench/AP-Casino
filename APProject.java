import java.util.*;
public class APProject {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // initialize players
    Player player1 = new Player(0, 0, 100, "Player 1", 0);
    Player player2 = new Player(0, 0, 100, "Player 2", 0);
    System.out.println(
        "Please type associated numbers and press enter to make choices!");
    System.out.println();
    while (true) {
      // main menu
      System.out.println("What would you like to do?");
      System.out.println("1. Play single player blackjack");
      System.out.println("2. Play two player blackjack");
      System.out.println("3. Play slots");
      System.out.println("4. Read blackjack rules");
      System.out.println("5. Read slots rules");
      System.out.println("6. Reset Game");
      System.out.println("7. See your game stats");
      System.out.println("8. Quit game");
      int menuchoice = sc.nextInt();
      // singleplayer
      if (menuchoice == 1) {
        int playerchoice;
        while (true) {
          System.out.println("Who is playing?");
          System.out.println("1. Player 1");
          System.out.println("2. Player 2");
          playerchoice = sc.nextInt();
          if (playerchoice == 1 | playerchoice == 2) {
            break;
          } else {
            System.out.println("There isn't a player with that number!");
          }
        }
        if (playerchoice == 1) {
          double earned = singleplayer(player1);
          player1.money = player1.money + earned;
          player1.plays++;
          if (earned > 0) {
            player1.moneyearned = player1.moneyearned + earned;
            player1.wins++;
          }
        }
        if (playerchoice == 2) {
          double earned = singleplayer(player2);
          player2.money = player2.money + earned;
          player2.plays++;
          if (earned > 0) {
            player2.moneyearned = player2.moneyearned + earned;
            player2.wins++;
          }
        }
      }
      // two player
      if (menuchoice == 2) {
        double[] twoplayermoney = twoplayer(player1, player2);
        player1.money = player1.money + twoplayermoney[0];
        player2.money = player2.money + twoplayermoney[1];
        if (twoplayermoney[0] > 0) {
          player1.moneyearned = player1.moneyearned + twoplayermoney[0];
          player1.wins++;
        }
        if (twoplayermoney[1] > 0) {
          player2.moneyearned = player2.moneyearned + twoplayermoney[1];
          player2.wins++;
        }
      }
      // slots
      if (menuchoice == 3) {
        int playerchoice;
        while (true) {
          System.out.println("Who is playing?");
          System.out.println("1. Player 1");
          System.out.println("2. Player 2");
          playerchoice = sc.nextInt();
          if (playerchoice == 1 | playerchoice == 2) {
            break;
          } else {
            System.out.println("There isn't a player with that number!");
          }
        }
        if (playerchoice == 1) {
          double earned = slots(player1);
          player1.money = player1.money + earned;
          player1.plays++;
          if (earned > 0) {
            player1.moneyearned = player1.moneyearned + earned;
            player1.wins++;
          }
        }
        if (playerchoice == 2) {
          double earned = slots(player2);
          player2.money = player2.money + earned;
          player2.plays++;
          if (earned > 0) {
            player2.moneyearned = player2.moneyearned + earned;
            player2.wins++;
          }
        }
      }
      // blakcjack instructions
      if (menuchoice == 4) {
        System.out.println(
            "Welcome to Blackjack! The goal of the game is to have a higher score than the dealer while not passing 21. \n"
            + "The game is played with a deck of cards. Aces (just called 11s in this game) are worth 11 or 1 depending \n"
            + "on what you need for your hand. The game will automatically choose for you. \n"
            + "Face cards are worth 10, and just called 10s in this game. First, the player(s) bet. Everyone starts with 2 cards. \n"
            + "If you start with 21 (An 11 and a 10), you automatically win and get double and a half of your bet back. \n"
            + "One of the dealers two cards are not visible. Now, you can either hit, which is drawing a new card \n"
            + "(with the chance that your hand would exceed 21, in which case you bust, A.K.A. lose) or stay with the cards you have. \n"
            + "The player(s) take turns hitting, until each person is satisfied with their hand and stayed, or busted. \n"
            + "Once this happens, the dealer will hit until they either have a hand over 16 or have busted. \n"
            + "If the dealer busts, the player(s) win and get double their money back. If not, the player(s) and dealer compares scores. \n"
            + "If you have a higher score than the dealer, you win and get double your money back. \n"
            + "If you have less, you lose. Losing means you lose your bet.");
        System.out.println("");
        System.out.println("(Press any key and enter to go back)");
        String back = sc.next();
      }
      // slots instructions
      if (menuchoice == 5) {
        System.out.println("Symbols: $, X, O");
        System.out.println("Ways to win:");
        System.out.println("$ $ $: Jackpot (5x money back)");
        System.out.println("O O O: Big win (3x money back)");
        System.out.println("X X X: Big win (3x money back)");
        System.out.println("$ $ O or $ $ X: Small win (2x money back)");
        System.out.println("");
        System.out.println("(Press any key and enter to go back)");
        String back = sc.next();
      }
      // reset
      if (menuchoice == 6) {
        System.out.println(
            "Are you sure? This will reset both players stats (money will go back to $100, games played reset , etc.");
        System.out.println("1. Yes");
        System.out.println("2. No");
        int resetchoice = sc.nextInt();
        if (resetchoice == 1) {
          player1.Reset();
          player2.Reset();
        }
      }
      // See stats
      if (menuchoice == 7) {
        int playerchoice;
        while (true) {
          System.out.println("Who's stats would you like to see?");
          System.out.println("1. Player 1");
          System.out.println("2. Player 2");
          playerchoice = sc.nextInt();
          if (playerchoice == 1 | playerchoice == 2) {
            break;
          } else {
            System.out.println("There isn't a player with that number!");
          }
        }
        if (playerchoice == 1) {
          System.out.println(player1);
          System.out.println("(Press any key and enter to go back)");
          String back = sc.next();
        }
        if (playerchoice == 2) {
          System.out.println(player2);
          System.out.println("(Press any key and enter to go back)");
          String back = sc.next();
        }
      }
      // Quit game
      if (menuchoice == 8) {
        System.out.println(
            "Are you sure? All your data (name, wins, etc.) will be deleted!");
        System.out.println("1. Quit");
        System.out.println("2. Go Back");
        int quitchoice = sc.nextInt();
        if (quitchoice == 1) {
          break;
        }
      }
    }
  }
  public static double singleplayer(Player player) {
    double bet;
    Random r = new Random();
    Scanner sc = new Scanner(System.in);
    // choose bet
    while (true) {
      System.out.println(
          "How much would you like to bet? (You have $" + player.money + ")");
      bet = sc.nextDouble();
      if (bet < 1) {
        System.out.println("Bet can't be negative or less than 1!");
      } else if (bet > player.money) {
        System.out.println("Bet can't be more money than you have!");
      } else {
        break;
      }
    }
    // make deck and draw cards
    int playerAces = 0;
    int dealerAces = 0;
    ArrayList<Integer> cards = new ArrayList<Integer>(
        Arrays.asList(2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6,
            6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11));
    int drawcard1 = r.nextInt(cards.size());
    Integer playercard1 = cards.get(drawcard1);
    cards.remove(drawcard1);
    if (playercard1 == 11) {
      playerAces++;
    }
    int drawdealercard1 = r.nextInt(cards.size());
    Integer dealercard1 = cards.get(drawdealercard1);
    cards.remove(drawdealercard1);
    if (dealercard1 == 11) {
      dealerAces++;
    }
    int drawcard2 = r.nextInt(cards.size());
    Integer playercard2 = cards.get(drawcard2);
    cards.remove(drawcard2);
    if (playercard2 == 11) {
      playerAces++;
    }
    int drawdealercard2 = r.nextInt(cards.size());
    Integer dealercard2 = cards.get(drawdealercard2);
    cards.remove(drawdealercard2);
    if (dealercard2 == 11) {
      dealerAces++;
    }
    Integer playersum = playercard1 + playercard2;
    System.out.println("Your hand is " + playercard1 + " and " + playercard2
        + ", sum of " + playersum);
    System.out.println("Dealers face up card is a " + dealercard1);
    boolean ifBlackjack = checkBlackjack(playersum);
    if (ifBlackjack == true) {
      System.out.println("Blackjack! You win $" + bet * 1.5 + "!");
      System.out.println("(Press any key and enter to go back)");
      String back = sc.next();
      return bet * 1.5;
    }
    // player hits or stays
    boolean ifstay = false;
    while (ifstay == false) {
      System.out.println("Would you like to hit or stay?");
      System.out.println("1. Hit");
      System.out.println("2. Stay");
      int hitchoice = sc.nextInt();
      if (hitchoice == 1) {
        int drawhit = r.nextInt(cards.size());
        Integer hitcard = cards.get(drawhit);
        cards.remove(drawhit);
        if (hitcard == 11) {
          playerAces++;
        }
        playersum = playersum + hitcard;
        System.out.println("You hit a " + hitcard);
        boolean ifbust = checkBust(playersum);
        if (ifbust == true) {
          if (playerAces > 0) {
            playersum = playersum - 10;
            playerAces--;
          } else {
            System.out.println("You busted!");
            System.out.println("(Press any key and enter to go back)");
            String back = sc.next();
            return bet * -1;
          }
        }
        System.out.println("Your total is " + playersum);
      }
      if (hitchoice == 2) {
        ifstay = true;
      }
    }
    // dealer hits if necessary
    Integer dealersum = dealercard1 + dealercard2;
    ArrayList<Integer> dealercards = new ArrayList<Integer>();
    dealercards.add(dealercard1);
    dealercards.add(dealercard2);
    if (dealersum > 21) {
      if (dealerAces > 0) {
        dealersum = dealersum - 10;
        dealerAces--;
      }
    }
    while (dealersum < 17) {
      int drawhit = r.nextInt(cards.size());
      Integer hitcard = cards.get(drawhit);
      cards.remove(drawhit);
      dealersum = dealersum + hitcard;
      dealercards.add(hitcard);
      boolean dealerbust = checkBust(dealersum);
      if (dealerbust == true) {
        if (dealerAces > 0) {
          dealersum = dealersum - 10;
          dealerAces--;
        } else {
          System.out.print("Dealers cards: ");
          for (int x = 0; x < dealercards.size(); x++) {
            System.out.print(dealercards.get(x) + " ");
          }
          System.out.println("");
          System.out.println("Dealers hand: " + dealersum);
          System.out.println("Dealer busted! You win $" + bet + "!");
          System.out.println("(Press any key and enter to go back)");
          String back = sc.next();
          return bet;
        }
      }
    }
    // check who wins
    System.out.print("Dealers cards: ");
    for (int x = 0; x < dealercards.size(); x++) {
      System.out.print(dealercards.get(x) + " ");
    }
    System.out.println("");
    System.out.println("Dealers hand: " + dealersum);
    if (playersum > dealersum) {
      System.out.println("You win $" + bet + "!");
      System.out.println("(Press any key and enter to go back)");
      String back = sc.next();
      return bet;
    }
    if (playersum == dealersum) {
      System.out.println("Push (Tie)! You get your bet back.");
      System.out.println("(Press any key and enter to go back)");
      String back = sc.next();
      return 0;
    }
    if (playersum < dealersum) {
      System.out.println("Dealer wins! :(");
      System.out.println("(Press any key and enter to go back)");
      String back = sc.next();
      return bet * -1;
    }
    return 0;
  }
  public static double[] twoplayer(Player player1, Player player2) {
    double[] returned = new double[2];
    double bet1;
    double bet2;
    Random r = new Random();
    Scanner sc = new Scanner(System.in);
    // choose bets
    while (true) {
      System.out.println("How much would Player 1 like to bet? (You have $"
          + player1.money + ")");
      bet1 = sc.nextDouble();
      if (bet1 < 1) {
        System.out.println("Bet can't be negative or less than 1!");
      } else if (bet1 > player1.money) {
        System.out.println("Bet can't be more money than you have!");
      } else {
        break;
      }
    }
    while (true) {
      System.out.println("How much would Player 2 like to bet? (You have $"
          + player2.money + ")");
      bet2 = sc.nextDouble();
      if (bet2 < 1) {
        System.out.println("Bet can't be negative or zero!");
      } else if (bet2 > player2.money) {
        System.out.println("Bet can't be more money than you have!");
      } else {
        break;
      }
    }
    // make deck and draw cards
    int player1Aces = 0;
    int player2Aces = 0;
    int dealerAces = 0;
    ArrayList<Integer> cards = new ArrayList<Integer>(
        Arrays.asList(2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 5, 5, 5, 5, 6, 6, 6,
            6, 7, 7, 7, 7, 8, 8, 8, 8, 9, 9, 9, 9, 10, 10, 10, 10, 10, 10, 10,
            10, 10, 10, 10, 10, 10, 10, 10, 10, 11, 11, 11, 11));
    int p1draw1 = r.nextInt(cards.size());
    Integer p1card1 = cards.get(p1draw1);
    cards.remove(p1draw1);
    if (p1card1 == 11) {
      player1Aces++;
    }
    int p2draw1 = r.nextInt(cards.size());
    Integer p2card1 = cards.get(p2draw1);
    cards.remove(p2draw1);
    if (p2card1 == 11) {
      player2Aces++;
    }
    int drawdealercard1 = r.nextInt(cards.size());
    Integer dealercard1 = cards.get(drawdealercard1);
    cards.remove(drawdealercard1);
    if (dealercard1 == 11) {
      dealerAces++;
    }
    int p1draw2 = r.nextInt(cards.size());
    Integer p1card2 = cards.get(p1draw2);
    cards.remove(p1draw2);
    if (p1card2 == 11) {
      player2Aces++;
    }
    int p2draw2 = r.nextInt(cards.size());
    Integer p2card2 = cards.get(p2draw2);
    cards.remove(p2draw2);
    if (p2card2 == 11) {
      player2Aces++;
    }
    int drawdealercard2 = r.nextInt(cards.size());
    Integer dealercard2 = cards.get(drawdealercard2);
    cards.remove(drawdealercard2);
    if (dealercard2 == 11) {
      dealerAces++;
    }
    Integer p1sum = p1card1 + p1card2;
    Integer p2sum = p2card1 + p2card2;
    System.out.println("Player 1:");
    System.out.println(
        "Your hand is " + p1card1 + " and " + p1card2 + ", sum of " + p1sum);
    System.out.println("Player 2:");
    System.out.println(
        "Your hand is " + p2card1 + " and " + p2card2 + ", sum of " + p2sum);
    System.out.println("Dealers face up card is a " + dealercard1);
    boolean p1Blackjack = checkBlackjack(p1sum);
    if (p1Blackjack == true) {
      System.out.println(
          "Player 1 has blackjack! You win $" + bet1 * 1.5 + "!");
      returned[0] = bet1 * 1.5;
    }
    boolean p2Blackjack = checkBlackjack(p2sum);
    if (p2Blackjack == true) {
      System.out.println(
          "Player 2 has blackjack! You win $" + bet1 * 1.5 + "!");
      returned[1] = bet2 * 1.5;
    }
    if (returned[0] == bet1 * 1.5 && returned[1] == bet2 * 1.5) {
      return returned;
    }
    // player hits or stays
    boolean p1bust = false;
    boolean p2bust = false;
    boolean p1stay = false;
    boolean p2stay = false;
    while (true) {
      if (p1stay == false) {
        System.out.println("Player 1:");
        System.out.println("Would you like to hit or stay?");
        System.out.println("1. Hit");
        System.out.println("2. Stay");
        int hitchoice = sc.nextInt();
        if (hitchoice == 1) {
          int drawhit = r.nextInt(cards.size());
          Integer hitcard = cards.get(drawhit);
          cards.remove(drawhit);
          if (hitcard == 11) {
            player1Aces++;
          }
          p1sum = p1sum + hitcard;
          System.out.println("You hit a " + hitcard);
          boolean ifbust = checkBust(p1sum);
          if (ifbust == true) {
            if (player1Aces > 0) {
              p1sum = p1sum - 10;
              player1Aces--;
            } else {
              System.out.println("Player 1 busted!");
              p1bust = true;
              returned[0] = bet1 * -1;
              p1stay = true;
            }
          }
          if (p1bust = false) {
            System.out.println("Your total is " + p1sum);
          }
        }
        if (hitchoice == 2) {
          p1stay = true;
        }
      }
      if (p2stay == false) {
        System.out.println("Player 2:");
        System.out.println("Would you like to hit or stay?");
        System.out.println("1. Hit");
        System.out.println("2. Stay");
        int hitchoice = sc.nextInt();
        if (hitchoice == 1) {
          int drawhit = r.nextInt(cards.size());
          Integer hitcard = cards.get(drawhit);
          cards.remove(drawhit);
          if (hitcard == 11) {
            player2Aces++;
          }
          p2sum = p2sum + hitcard;
          System.out.println("You hit a " + hitcard);
          boolean ifbust = checkBust(p2sum);
          if (ifbust == true) {
            if (player2Aces > 0) {
              p2sum = p2sum - 10;
              player2Aces--;
            } else {
              System.out.println("Player 2 busted!");
              p2bust = true;
              returned[1] = bet2 * -1;
              p2stay = true;
            }
          }
          if (p1bust = false) {
            System.out.println("Your total is " + p1sum);
          }
        }
        if (hitchoice == 2) {
          p2stay = true;
        }
      }
      if (p1stay == true && p2stay == true) {
        break;
      }
    }
    if (p1bust == true && p2bust == true) {
      return returned;
    }
    // dealer hits if necessary
    Integer dealersum = dealercard1 + dealercard2;
    ArrayList<Integer> dealercards = new ArrayList<Integer>();
    dealercards.add(dealercard1);
    dealercards.add(dealercard2);
    if (dealersum > 21) {
      if (dealerAces > 0) {
        dealersum = dealersum - 10;
        dealerAces--;
      }
    }
    while (dealersum < 17) {
      int drawhit = r.nextInt(cards.size());
      Integer hitcard = cards.get(drawhit);
      cards.remove(drawhit);
      if (hitcard == 11) {
        dealerAces++;
      }
      dealersum = dealersum + hitcard;
      dealercards.add(hitcard);
      boolean dealerbust = checkBust(dealersum);
      if (dealerbust == true) {
        if (dealerAces > 0) {
          dealersum = dealersum - 10;
          dealerAces--;
        } else {
          System.out.print("Dealers cards: ");
          for (int x = 0; x < dealercards.size(); x++) {
            System.out.print(dealercards.get(x) + " ");
          }
          System.out.println("");
          System.out.println("Dealers hand: " + dealersum);
          System.out.println("Dealer busted!");
          if (p1bust == false) {
            System.out.print("P1 wins $" + bet1 + "! ");
          }
          if (p2bust == false) {
            System.out.print("P2 wins $" + bet2 + "!");
          }
          System.out.println("(Press any key and enter to go back)");
          String back = sc.next();
          if (p1bust == false) {
            returned[0] = bet1;
          }
          if (p2bust == false) {
            returned[1] = bet2;
          }
          return returned;
        }
      }
    }
    // check who wins
    System.out.print("Dealers cards: ");
    for (int x = 0; x < dealercards.size(); x++) {
      System.out.print(dealercards.get(x) + " ");
    }
    System.out.println("");
    System.out.println("Dealers hand: " + dealersum);
    if (p1bust == false && returned[0] != bet1 * 1.5) {
      if (p1sum > dealersum) {
        System.out.println("Player 1 wins $" + bet1 + "!");
        returned[0] = bet1;
      }
      if (p1sum == dealersum) {
        System.out.println(" Player 1 pushes (Tie)! You get your bet back.");
        returned[0] = 0;
      }
      if (p1sum < dealersum) {
        System.out.println("Player 1 loses! :(");
        returned[0] = bet1 * -1;
      }
    }
    if (p2bust == false && returned[0] != bet1 * 1.5) {
      if (p2sum > dealersum) {
        System.out.println("Player 2 wins $" + bet2 + "!");
        returned[1] = bet2;
      }
      if (p2sum == dealersum) {
        System.out.println(" Player 2 pushes (Tie)! You get your bet back.");
        returned[1] = 0;
      }
      if (p2sum < dealersum) {
        System.out.println("Player 2 loses! :(");
        returned[1] = bet1 * -1;
      }
    }
    System.out.println("(Press any key and enter to go back)");
    String back = sc.next();
    return returned;
  }
  public static double slots(Player player) {
    Scanner sc = new Scanner(System.in);
    Random r = new Random();
    // player decides bet
    double bet;
    while (true) {
      System.out.println(
          "How much would you like to bet? (You have $" + player.money + ")");
      bet = sc.nextDouble();
      if (bet < 1) {
        System.out.println("Bet can't be negative or less than 1!");
      } else if (bet > player.money) {
        System.out.println("Bet can't be more money than you have!");
      } else {
        break;
      }
    }
    // slot machine rolls
    int[] rolls = new int[] {r.nextInt(3), r.nextInt(3), r.nextInt(3)};
    char[] slots = new char[3];
    for (int x = 0; x < 3; x++) {
      rolls[x]++;
    }
    for (int x = 0; x < 3; x++) {
      if (rolls[x] == 1) {
        slots[x] = '$';
      }
      if (rolls[x] == 2) {
        slots[x] = 'O';
      }
      if (rolls[x] == 3) {
        slots[x] = 'X';
      }
    }
    System.out.println("Rolling!");
    System.out.println();
    for (int x = 0; x < 3; x++) {
      System.out.print(slots[x] + " ");
      pause(1000);
    }
    System.out.println();
    // win conditions
    if (rolls[0] + rolls[1] + rolls[2] == 3) {
      System.out.println("JACKPOT!!");
      System.out.println("YOU WIN $" + bet * 5 + "!");
      System.out.println("(Press any key and enter to go back)");
      String back = sc.next();
      return bet * 8;
    } else if (rolls[0] + rolls[1] + rolls[2] == 6 && rolls[0] == 2
        && rolls[1] == 2 && rolls[2] == 2) {
      System.out.println("Big win!");
      System.out.println("You get $" + bet * 3 + "!");
      System.out.println("(Press any key and enter to go back)");
      String back = sc.next();
      return bet * 2;
    } else if (rolls[0] + rolls[1] + rolls[2] == 9) {
      System.out.println("Big win!");
      System.out.println("You get $" + bet * 3 + "!");
      System.out.println("(Press any key and enter to go back)");
      String back = sc.next();
      return bet * 2;
    } else if (rolls[0] + rolls[1] == 2 || rolls[2] + rolls[1] == 2
        || rolls[0] + rolls[2] == 2 && rolls[0] + rolls[1] + rolls[2] != 9) {
      System.out.println("Small win!");
      System.out.println("You get $" + bet * 2 + "!");
      System.out.println("(Press any key and enter to go back)");
      String back = sc.next();
      return bet * 2;
    } else {
      System.out.println("No prize :(");
      System.out.println("(Press any key and enter to go back)");
      String back = sc.next();
      return bet * -1;
    }
  }
  public static boolean checkBlackjack(Integer playersum) {
    if (playersum == 21) {
      return true;
    } else {
      return false;
    }
  }
  public static boolean checkBust(Integer playersum) {
    if (playersum > 21) {
      return true;
    } else {
      return false;
    }
  }
  static void pause(int milisecond) {
    try {
      Thread.sleep(milisecond);
    } catch (InterruptedException ex) {
    }
  }
}
class Player {
  int wins;
  int plays;
  double money;
  String name;
  double moneyearned;
  public Player(
      int Wins, int Plays, double Money, String Name, double MoneyEarned) {
    wins = Wins;
    plays = Plays;
    money = Money;
    name = Name;
    moneyearned = MoneyEarned;
  }
  public void Reset() {
    wins = 0;
    plays = 0;
    money = 0;
  }
  public String toString() {
    String stats = "Wins: " + wins + "\n"
        + "Plays: " + plays + "\n"
        + "Money: " + money + "\n"
        + "Money earned: " + moneyearned;
    return stats;
  }
}
