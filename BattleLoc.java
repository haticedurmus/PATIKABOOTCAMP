import java.util.Random;
public abstract class BattleLoc extends Location {
	protected Obstacle obstacle;
	protected String award;
	private Random random = new Random();

	BattleLoc(Player player, String name, Obstacle obstacle, String award) {
		super(player);
		this.obstacle = obstacle;
		this.name = name;
		this.award = award;
	}

	public boolean getLocation() {
		int obsCount = obstacle.count();
		System.out.println("suan buradas�n�z : " + this.getName());
		System.out.println("Dikkatli ol! Burada " + obsCount + " tane " + obstacle.getName() + " yasiyor !");
		System.out.print("<S>avas veya <K>ac :");
		String selCase = scan.nextLine();
		selCase = selCase.toUpperCase();
		if (selCase.equals("S")) {
			if (combat(obsCount)) {
				System.out.println(this.getName() + " bolgesindeki tum dusmanlari temizlediniz !");
				if (this.award.equals("Food") && player.getInv().isFood() == false) {
					System.out.println(this.award + " Kazandiniz! ");
					player.getInv().setFood(true);
				} else if (this.award.equals("Water") && player.getInv().isWater() == false) {
					System.out.println(this.award + " Kazandiniz! ");
					player.getInv().setWater(true);
				} else if (this.award.equals("Firewood") && player.getInv().isFirewood() == false) {
					System.out.println(this.award + " Kazandiniz! ");
					player.getInv().setFirewood(true);
				}
				return true;
			}
			
			if(player.getHealth() <= 0) {
				System.out.println("oldunuz !");
				return false;
			}
		
		}
		return true;
	}


	public boolean combat(int obsCount) {
		for (int i = 0; i < obsCount; i++) {
			int defObsHealth = obstacle.getHealth();
			playerState();
			obstacleState(i+1);
			while (player.getHealth() > 0 && obstacle.getHealth() > 0) {


				System.out.print("<V>ur veya <K>ac :");
				String selCase = scan.nextLine();
				selCase = selCase.toUpperCase();


				int randomStart = random.nextInt(2) + 1;

				// if randomStart is 2, the player will hit first
				if (randomStart == 2) {

					//hit = playerHitFirst();

					if (selCase.equals("V")) {
						System.out.println("Önce siz vurdunuz !");
						if( obstacle.getHealth() - player.getTotalDamage() <0){
							obstacle.setHealth(0);
						}else {
							obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
						}
						afterHit();
						if (obstacle.getHealth() > 0) {
							System.out.println();
							System.out.println("Canavar size vurdu !");
							if(player.getHealth() - (obstacle.getDamage() - player.getInv().getArmor()) < 0){
								obstacle.setHealth(0);
							}else {
								player.setHealth(player.getHealth() - (obstacle.getDamage() - player.getInv().getArmor()));
							}
							afterHit();
						}
					} else {
						return false;
					}

				}

				else if (randomStart == 1){

					if (obstacle.getHealth() > 0 && selCase.equals("V")) {
						System.out.println();
						System.out.println("Önce canavar size vurdu !");
						if(player.getHealth() - (obstacle.getDamage() - player.getInv().getArmor()) < 0){
							obstacle.setHealth(0);
						}else {
							player.setHealth(player.getHealth() - (obstacle.getDamage() - player.getInv().getArmor()));
						}						afterHit();
					}
					else if(selCase.equals("K")){
						System.out.println("Kaçtınız..");
						return false;
					}
					System.out.println("Siz vurdunuz !");
					if( obstacle.getHealth() - player.getTotalDamage() <0){
						obstacle.setHealth(0);
					}else {
						obstacle.setHealth(obstacle.getHealth() - player.getTotalDamage());
					}
					afterHit();

				}

			}

			if (obstacle.getHealth() < player.getHealth()) {
				System.out.println("D��man� yendiniz !");

				if(this.getName()== "Mine"){
					minePossibilities();
				}
				else {
					player.setMoney(player.getMoney() + obstacle.getAward());
				}

				System.out.println("Guncel Paranız : " + player.getMoney());
				obstacle.setHealth(defObsHealth);
			} else {
				return false;
			}
			System.out.println("-------------------");
		}
		return true;
	}


	public void playerState() {
		System.out.println("Oyuncu Degerleri\n--------------");
		System.out.println("Can:" + player.getHealth());
		System.out.println("Hasar:" + player.getTotalDamage());
		System.out.println("Para:" + player.getMoney());
		if (player.getInv().getDamage() > 0) {
			System.out.println("Silah:" + player.getInv().getWeaponName());
		}
		if (player.getInv().getArmor() > 0) {
			System.out.println("Zırh:" + player.getInv().getArmorName());
		}
	}

	public void obstacleState(int i) {
		System.out.println("\n" + i +". "+ obstacle.getName() + " Degerleri\n--------------");
		System.out.println("Can:" + obstacle.getHealth());
		System.out.println("Hasar:" + obstacle.getDamage());
		System.out.println("Odul:" + obstacle.getAward());
	}

	public void afterHit() {
		System.out.println("Oyuncu Cani:" + player.getHealth());
		System.out.println(obstacle.getName() + " Cani:" + obstacle.getHealth());
		System.out.println();
	}

	public void minePossibilities() {

		// Player will recieve randomly Weapon or Archor or Money or Nothing
		// weapon -> %15 , Archor -> %15 , Money -> %25 , Nothing -> %45
		int randomPrize = random.nextInt(100) + 1;

		if (randomPrize <= 15) {

			//recieving randomly one weapon for killing the monster
			int randomWeapon = random.nextInt(100) + 1;

			if (randomWeapon <= 20) {
				this.getPlayer().getInv().setWeaponName("Tabanca");
				this.getPlayer().getInv().setDamage(2);
			}
			if (randomWeapon > 20 && randomWeapon <= 50) {

				this.getPlayer().getInv().setWeaponName("Kilic");
				this.getPlayer().getInv().setDamage(3);

			}
			if (randomWeapon > 50 && randomWeapon <= 100) {

				this.getPlayer().getInv().setWeaponName("Tufek");
				this.getPlayer().getInv().setDamage(7);

			}
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			System.out.println(this.getPlayer().getName() + ", you got one Weapon '" + this.getPlayer().getInv().getWeaponName() + "' as unexpected prize for killing one snake.");
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		} else if (randomPrize > 15 && randomPrize <= 30) {

			//recieving randomly one Archor for killing the monster
			int randomArchor = random.nextInt(100) + 1;

			if (randomArchor <= 20) {

				this.getPlayer().getInv().setArmorName("hafif");
				this.getPlayer().getInv().setArmor(1);
			} else if (randomArchor > 20 && randomArchor <= 50) {

				this.getPlayer().getInv().setArmorName("orta");
				this.getPlayer().getInv().setArmor(3);

			} else if (randomArchor > 50 && randomArchor <= 100) {

				this.getPlayer().getInv().setArmorName("agir");
				this.getPlayer().getInv().setArmor(5);

			}

			System.out.println("------------------------------------------------------------------------");
			System.out.println(this.getPlayer().getName() + ", you got one Armor '" + this.getPlayer().getInv().getArmorName() + "' as suprise prize for killing one snake.");
			System.out.println("------------------------------------------------------------------------");
		} else if (randomPrize > 30 && randomPrize <= 55) {

			int randomMoney = random.nextInt(100) + 1;
			int balance = this.getPlayer().getMoney();

			if (randomMoney <= 20) {

				this.getPlayer().setMoney(balance + 10);
			} else if (randomMoney > 20 && randomMoney <= 50) {

				this.getPlayer().setMoney(balance + 5);
			} else if (randomMoney > 50 && randomMoney <= 100) {

				this.getPlayer().setMoney(balance + 1);
			}

			System.out.println("------------------------------------------------------------------------");
			System.out.printf(this.getPlayer().getName() + ", you got " + (this.getPlayer().getMoney() - balance) + "$ as suprise prize for killing one snake\n");
			System.out.println("------------------------------------------------------------------------");
		} else if (randomPrize > 55 && randomPrize <= 100) {

			//hiçbir sey kazanmama ihitmali
		}
	}

}


