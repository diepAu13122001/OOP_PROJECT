package Test;

import java.util.*;

public class Timekeeping implements Position {
	private String workerIDInput;
	private String workerPassInput;
	private String ok;
	private String cancel;
	private String success;

	public Timekeeping() {
		workerIDInput = "Moi ban nhap ID cua minh: ";
		workerPassInput = "Moi ban nhap Password cua minh: ";
		ok = "Nhan 1 de hoan thanh viec diem danh.";
		cancel = "Nhan 2 de quay lai trang chu.";
		success = "Ban da dang nhap thanh cong ...";
	}

	@Override
	public String intro() {
		return "";
	}

	@Override
	public String chooseYourPosition() {
		System.out.print(workerIDInput);
		String id = insertString();

		System.out.print("\n" + workerPassInput);
		String pass = insertString();

		System.out.println(ok + "\n" + cancel);
		String a = insertString();
		if (a.equals("1")) {
			return chooseYourPosition();
		} else if (a.equals("2")) {
			return "Ban dang quay lai trang chu ...";
		}
		return "";
	}

	public String insertString() {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		return input;
	}
}
