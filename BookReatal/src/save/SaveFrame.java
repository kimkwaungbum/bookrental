package save;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import list.ListFrame;
import save.repo.SaveRepo;

public class SaveFrame extends JFrame {

	JButton b1 = new JButton("일람으로");
	JButton b2 = new JButton("초기화");
	JButton b3 = new JButton("등록");

	public SaveFrame() {
		setTitle("도서관리시스템 - 등록화면");
		setSize(400, 300);

		setPanel();

		setLocationRelativeTo(null);
		setVisible(true);
	}
//	private void setButtonPanel() {
//	// TODO 自動生成されたメソッド・スタブ
//	JPanel p = new JPanel(new GridLayout(1, 3));
//	p.setSize(400, 10);
//	JButton b1 = new JButton("초기화");
//	JButton b2 = new JButton("등록");
//	JButton b3 = new JButton("등록");
//
//	p.add(b1);
//	p.add(b2);
//	p.add(b3);
//	add(p);
//}
	private void setPanel() {
	// TODO 自動生成されたメソッド・スタブ
	JPanel p = new JPanel(new GridLayout(0, 3));
	p.setSize(400, 500);
	JLabel l1 = new JLabel("책제목");
	JLabel l2 = new JLabel("카테고리");
	JLabel l3 = new JLabel("저자");
	JLabel l4 = new JLabel("출판사");
	JLabel l5 = new JLabel("책가격");
	JLabel l6 = new JLabel("상태");
	JLabel l7 = new JLabel("대여비");

	JLabel empty1 = new JLabel("");
	JLabel empty2 = new JLabel("");
	JLabel empty3 = new JLabel("");
	JLabel empty4 = new JLabel("");
	JLabel empty5 = new JLabel("");
	JLabel empty6 = new JLabel("");
	JLabel empty7 = new JLabel("");

	JTextField t1 = new JTextField(10);
	JTextField t2 = new JTextField(10);
	JTextField t3 = new JTextField(10);
	JTextField t4 = new JTextField(10);
	JTextField t5 = new JTextField(10);
	JTextField t6 = new JTextField(10);
	JTextField t7 = new JTextField(10);


	p.add(l1);
	p.add(empty1);
	p.add(t1);
	p.add(l2);
	p.add(empty2);
	p.add(t2);
	p.add(l3);
	p.add(empty3);
	p.add(t3);
	p.add(l4);
	p.add(empty4);
	p.add(t4);
	p.add(l5);
	p.add(empty5);
	p.add(t5);
	p.add(l6);
	p.add(empty6);
	p.add(t6);
	p.add(l7);
	p.add(empty7);
	p.add(t7);


	p.add(b1);
	p.add(b2);
	p.add(b3);

	add(p);

	b1.addActionListener(e-> {
		setVisible(false);
		new ListFrame();
	});
	b3.addActionListener(e -> {
		SaveRepo sp = new SaveRepo();
		String title = t1.getText();
		String category = t2.getText();
		String writter = t3.getText();
		String company = t4.getText();
		int price = Integer.parseInt(t5.getText());
		String status = t6.getText();
		int rental_price = Integer.parseInt(t7.getText());
		boolean result = sp.save(title, category, writter, company, price, status, rental_price);
		if(result) {
			JOptionPane.showConfirmDialog(null, "등록하시겠습니까?", "도서등록", JOptionPane.YES_NO_OPTION);
			setVisible(false);
			new ListFrame();
		}
	});
}

public static void main(String[] args) {
	// TODO 自動生成されたメソッド・スタブ
	new SaveFrame();
}

}