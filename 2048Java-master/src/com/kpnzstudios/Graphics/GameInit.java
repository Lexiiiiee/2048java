package com.kpnzstudios.Graphics;
import javax.swing.*;  
import java.awt.*;  
import java.awt.event.ActionEvent;  
import java.awt.event.ActionListener;
import java.util.HashMap; 
public class GameInit {
	 private HashMap<String, String> users = new HashMap<>(); // 存储用户名和密码 
	public static void main(String[] args) { 
		SwingUtilities.invokeLater(() -> new GameInit().showLoginFrame()); 
	}
	 // 显示登录界面  
	 public void showLoginFrame() {  
        LoginFrame loginFrame = new LoginFrame(this);  
        loginFrame.setVisible(true);  
    }  

    // 显示注册界面  
    public void showRegisterFrame() {  
        RegisterFrame registerFrame = new RegisterFrame(this);  
        registerFrame.setVisible(true);  
    }  

    // 显示游戏界面  
    public void showGameFrame() {  
        Game2048Interface game = new Game2048Interface();  
        JFrame frame = new JFrame("2048");  
        frame.add(game);  
        frame.setResizable(false);  
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frame.pack();  
        frame.setVisible(true);  
        new Thread(game).start(); // 启动游戏线程  
    }  

    // 注册用户  
    public boolean registerUser(String username, String password) {  
        if (users.containsKey(username)) {  
            return false; // 用户名已存在  
        }  
        users.put(username, password); // 存储用户名和密码  
        return true; // 注册成功  
    }  

    // 验证用户  
    public boolean validateUser(String username, String password) {  
        return password.equals(users.get(username)); // 验证用户名和密码  
    }  
}  

// 登录界面类  
class LoginFrame extends JFrame {  
    private JTextField usernameField;  
    private JPasswordField passwordField;  
    private GameInit app; // 引用主应用程序类  

    public LoginFrame(GameInit app) {  
        this.app = app; // 初始化主应用程序类的引用  
        setTitle("2048 Game Login"); // 设置窗口标题  
        setSize(300, 200); // 设置窗口大小  
        setDefaultCloseOperation(EXIT_ON_CLOSE); // 设置关闭操作  
        setLocationRelativeTo(null); // 窗口居中显示  
        setLayout(new GridLayout(4, 2)); // 设置布局为网格布局  

        // 创建组件  
        JLabel usernameLabel = new JLabel("Username:");  
        usernameField = new JTextField();  
        JLabel passwordLabel = new JLabel("Password:");  
        passwordField = new JPasswordField();  
        JButton loginButton = new JButton("Login");  
        JButton registerButton = new JButton("Register");  

        // 添加按钮的事件监听器  
        loginButton.addActionListener(new LoginAction());  
        registerButton.addActionListener(e -> {  
            this.dispose(); // 关闭登录窗口  
            app.showRegisterFrame(); // 显示注册窗口  
        });  

        // 将组件添加到窗口  
        add(usernameLabel);  
        add(usernameField);  
        add(passwordLabel);  
        add(passwordField);  
        add(loginButton);  
        add(registerButton);  
    }  

    // 登录按钮的事件处理  
    private class LoginAction implements ActionListener {  
        @Override  
        public void actionPerformed(ActionEvent e) {  
            String username = usernameField.getText(); // 获取用户名  
            String password = new String(passwordField.getPassword()); // 获取密码  
            // 验证用户  
            if (app.validateUser(username, password)) {  
                JOptionPane.showMessageDialog(LoginFrame.this, "Login successful for " + username);  
                app.showGameFrame(); // 登录成功后打开游戏界面  
                dispose(); // 关闭登录窗口  
            } else {  
                JOptionPane.showMessageDialog(LoginFrame.this, "Invalid username or password.", "Error", JOptionPane.ERROR_MESSAGE);  
            }  
        }  
    }  
}  

// 注册界面类  
class RegisterFrame extends JFrame {  
    private JTextField usernameField;  
    private JPasswordField passwordField;  
    private GameInit app; // 引用主应用程序类  

    public RegisterFrame(GameInit app) {  
        this.app = app; // 初始化主应用程序类的引用  
        setTitle("2048 Game Register"); // 设置窗口标题  
        setSize(300, 200); // 设置窗口大小  
        setDefaultCloseOperation(EXIT_ON_CLOSE); // 设置关闭操作  
        setLocationRelativeTo(null); // 窗口居中显示  
        setLayout(new GridLayout(4, 2)); // 设置布局为网格布局  

        // 创建组件  
        JLabel usernameLabel = new JLabel("Username:");  
        usernameField = new JTextField();  
        JLabel passwordLabel = new JLabel("Password:");  
        passwordField = new JPasswordField();  
        JButton registerButton = new JButton("Register");  
        JButton backButton = new JButton("Back to Login");  

        // 添加按钮的事件监听器  
        registerButton.addActionListener(new RegisterAction());  
        backButton.addActionListener(e -> {  
            this.dispose(); // 关闭注册窗口  
            app.showLoginFrame(); // 显示登录窗口  
        });  

        // 将组件添加到窗口  
        add(usernameLabel);  
        add(usernameField);  
        add(passwordLabel);  
        add(passwordField);  
        add(registerButton);  
        add(backButton);  
    }  

    // 注册按钮的事件处理  
    private class RegisterAction implements ActionListener {  
        @Override  
        public void actionPerformed(ActionEvent e) {  
            String username = usernameField.getText(); // 获取用户名  
            String password = new String(passwordField.getPassword()); // 获取密码  
            // 注册用户  
            if (app.registerUser(username, password)) {  
                JOptionPane.showMessageDialog(RegisterFrame.this, "Registration successful for " + username);  
                app.showGameFrame(); // 注册成功后打开游戏界面  
                dispose(); // 关闭注册窗口  
            } else {  
                JOptionPane.showMessageDialog(RegisterFrame.this, "Username already exists.", "Error", JOptionPane.ERROR_MESSAGE);  
            }  
        }  
    }  
}  
