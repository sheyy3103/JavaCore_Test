package session17.enity;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Player {
    private Integer playerId;
    private String playerName;
    private Boolean gender;
    private Date dateOfBirth;
    private String nationality;
    private String clubName;
    private String positionPlay;
    private Float transferCost;
    static final Scanner sc = new Scanner(System.in);
    static final DecimalFormat df = new DecimalFormat("#,###.##");
    static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public Player() {
        super();
    }

    public Player(Integer playerId, String playerName, Boolean gender, Date dateOfBirth, String nationality, String clubName, String positionPlay, Float transferCost) {
        super();
        this.playerId = playerId;
        this.playerName = playerName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
        this.nationality = nationality;
        this.clubName = clubName;
        this.positionPlay = positionPlay;
        this.transferCost = transferCost;
    }

    public Integer getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Integer playerId) {
        this.playerId = playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String clubName) {
        this.clubName = clubName;
    }

    public String getPositionPlay() {
        return positionPlay;
    }

    public void setPositionPlay(String positionPlay) {
        this.positionPlay = positionPlay;
    }

    public Float getTransferCost() {
        return transferCost;
    }

    public void setTransferCost(Float transferCost) {
        this.transferCost = transferCost;
    }

    public void inputData() {
        System.out.print("- Nhập họ tên cầu thủ: ");
        playerName = sc.nextLine();
        System.out.print("- Nhập giới tính (Nam: true/ Nữ: false): ");
        gender = Boolean.parseBoolean(sc.nextLine());
        System.out.print("- Nhập ngày tháng năm sinh: ");
        try {
            dateOfBirth = sdf.parse(sc.nextLine());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        System.out.print("- Nhập quốc tịch: ");
        nationality = sc.nextLine();
        System.out.print("- Nhập câu lạc bộ đang chơi: ");
        clubName = sc.nextLine();
        System.out.print("- Nhập vị trí thi đấu: ");
        positionPlay = sc.nextLine();
        System.out.print("- Nhập giá trị chuyển nhượng ($): ");
        transferCost = Float.parseFloat(sc.nextLine());
    }

    public void displayData() {
        System.out.println("\tMã cầu thủ: " + playerId);
        System.out.println("\tHọ tên cầu thủ: " + playerName);
        System.out.println("\tGiới tính: " + (gender ? "Nam" : "Nữ"));
        System.out.println("\tNgày tháng năm sinh: " + sdf.format(dateOfBirth));
        System.out.println("\tQuốc tịch: " + nationality);
        System.out.println("\tCâu lạc bộ: " + clubName);
        System.out.println("\tVị trí thi đấu: " + positionPlay);
        System.out.println("\tGiá trị chuyển nhượng: " + df.format(transferCost) + "$");
    }
}
