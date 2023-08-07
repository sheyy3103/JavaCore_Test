package session17.run;

import session17.dao.PlayerDAOImpl;
import session17.enity.Player;

import java.util.List;
import java.util.Scanner;

public class Main {
    static final Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println();

        while (true) {
            int choose;
            showMenu();
            choose = Integer.parseInt(sc.nextLine());
            switch (choose) {
                case 1 -> {
                    Player addedPlayer = new Player();
                    System.out.println("Nhập thông tin cầu thủ: ");
                    addedPlayer.inputData();
                    boolean bool1 = new PlayerDAOImpl().addPlayer(addedPlayer);
                    if (bool1) System.out.println("=> Thêm mới thành công!");
                    else System.out.println("=> Thêm mới thất bại");
                }
                case 2 -> {
                    List<Player> listPlayer = new PlayerDAOImpl().getPlayers();
                    System.out.println("Thông tin của tất cả cầu thủ: ");
                    for (Player player : listPlayer) {
                        System.out.println("- Cầu thủ: ");
                        player.displayData();
                    }
                }
                case 3 -> {
                    int id1;
                    System.out.print("Nhập mã cầu thủ cần tìm: ");
                    id1 = Integer.parseInt(sc.nextLine());
                    Player foundPlayer = new PlayerDAOImpl().getPlayerById(id1);
                    System.out.println("=> Cầu thủ tìm thấy: ");
                    foundPlayer.displayData();
                }
                case 4 -> {
                    int id2;
                    System.out.print("Nhập mã cầu thủ để cập nhật thông tin: ");
                    id2 = Integer.parseInt(sc.nextLine());
                    Player updatedPlayer = new Player();
                    System.out.println("Nhập thông tin mới của cầu thủ: ");
                    updatedPlayer.inputData();
                    boolean bool2 = new PlayerDAOImpl().updatePlayer(id2, updatedPlayer);
                    if (bool2) System.out.println("=> Cập nhật thành công!");
                    else System.out.println("=> Cập nhật thất bại");
                }
                case 5 -> {
                    int id3;
                    System.out.print("Nhập mã cầu thủ để xóa: ");
                    id3 = Integer.parseInt(sc.nextLine());
                    boolean bool3 = new PlayerDAOImpl().removePlayer(id3);
                    if (bool3) System.out.println("=> Xóa thành công!");
                    else System.out.println("=> Xóa thất bại");
                }
                case 6 -> {
                    String clubName;
                    System.out.print("Nhập tên câu lạc bộ: ");
                    clubName = sc.nextLine();
                    List<Player> playerList = new PlayerDAOImpl().getPlayersByClub(clubName);
                    System.out.println("Thông tin của tất cả cầu thủ câu lạc bộ " + clubName + ": ");
                    for (Player player : playerList) {
                        System.out.println("- Cầu thủ: ");
                        player.displayData();
                    }
                }
                case 7 -> System.exit(200);
                default -> {
                }
            }
        }
    }

    public static void showMenu() {
        System.out.println("----------MỤC LỤC----------");
        System.out.println("1. Thêm mới cầu thủ.");
        System.out.println("2. Hiển thị thông tin tất cả cầu thủ.");
        System.out.println("3. Xem chi tiết một cầu thủ.");
        System.out.println("4. Cập nhật thông tin cầu thủ.");
        System.out.println("5. Xóa thông tin cầu thủ.");
        System.out.println("6. Tìm kiếm thông tin cầu thủ theo câu lạc bộ.");
        System.out.println("7. Thoát.");
        System.out.print("Vui lòng chọn từ 1 đến 7: ");
    }
}
