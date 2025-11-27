# Spring Boot Login Page - Step by Step Guide

## What We Built

A complete login system with:
- ✅ User authentication with Spring Security
- ✅ Beautiful login page with modern styling
- ✅ Protected home page
- ✅ H2 in-memory database
- ✅ Password encryption (BCrypt)
- ✅ Test user pre-loaded

## Project Structure

```
src/main/java/com/brelin/loginPage/
├── model/
│   └── User.java                    # User entity (database table)
├── repository/
│   └── UserRepository.java          # Database operations
├── service/
│   └── CustomUserDetailsService.java # Loads user for authentication
├── controller/
│   └── AuthController.java          # Handles login/home pages
├── config/
│   ├── SecurityConfig.java          # Security settings
│   └── DataInitializer.java         # Creates test user
└── LoginPageApplication.java        # Main application

src/main/resources/
├── templates/
│   ├── login.html                   # Login page
│   └── home.html                    # Home page (after login)
└── application.properties           # Database configuration
```

## How to Run

1. **Build the project:**
   ```bash
   ./mvnw clean install
   ```

2. **Run the application:**
   ```bash
   ./mvnw spring-boot:run
   ```

3. **Open your browser:**
   ```
   http://localhost:8080
   ```

4. **Login with test credentials:**
   - Username: `admin`
   - Password: `password`

## How It Works

### 1. User Model (`User.java`)
- Stores user information in the database
- Fields: id, username, password (encrypted), email, role
- Uses JPA annotations to map to database table

### 2. User Repository (`UserRepository.java`)
- Interface for database operations
- Spring Data JPA automatically implements methods
- Custom method: `findByUsername()`

### 3. Security Service (`CustomUserDetailsService.java`)
- Tells Spring Security how to find users
- Loads user from database when someone tries to login
- Converts our User to Spring Security's UserDetails

### 4. Security Configuration (`SecurityConfig.java`)
- Sets up login page at `/login`
- Protects all pages except login
- Configures password encryption (BCrypt)
- Sets up logout functionality

### 5. Controllers (`AuthController.java`)
- `/login` - Shows login page
- `/home` - Shows home page (requires login)
- `/` - Redirects to home

### 6. Data Initializer (`DataInitializer.java`)
- Runs when application starts
- Creates a test user automatically
- Password is encrypted before saving

## Key Concepts Explained

### Spring Security
- Handles authentication (who you are)
- Handles authorization (what you can do)
- Automatically protects your pages
- Provides login/logout functionality

### BCrypt Password Encryption
- Never stores passwords in plain text
- One-way encryption (can't be decrypted)
- Each password gets a unique "salt"
- Very secure against attacks

### Thymeleaf Templates
- Server-side HTML templates
- `th:` attributes for dynamic content
- `sec:` attributes for security features
- Renders on the server before sending to browser

### H2 Database
- In-memory database (data lost when app stops)
- Perfect for development and testing
- Can view at: http://localhost:8080/h2-console
  - JDBC URL: `jdbc:h2:mem:logindb`
  - Username: `sa`
  - Password: (leave empty)

## Next Steps to Learn

### 1. Add Registration Page
Create a form where new users can sign up:
- Add a registration controller
- Create registration.html
- Add user validation
- Save new users to database

### 2. Add "Remember Me" Feature
Let users stay logged in:
```java
.rememberMe()
    .key("uniqueAndSecret")
    .tokenValiditySeconds(86400) // 24 hours
```

### 3. Add Password Reset
Let users reset forgotten passwords:
- Generate reset token
- Send email with reset link
- Create password reset form

### 4. Add User Roles
Different permissions for different users:
- ADMIN can access admin pages
- USER can only access user pages
- Use `@PreAuthorize("hasRole('ADMIN')")`

### 5. Switch to Real Database
Replace H2 with MySQL or PostgreSQL:
- Add database dependency
- Update application.properties
- Data persists between restarts

### 6. Add Profile Page
Let users update their information:
- View profile
- Edit email
- Change password
- Upload profile picture

## Common Issues & Solutions

### Port 8080 already in use
```bash
# Windows
netstat -ano | findstr :8080
taskkill /PID <PID> /F

# Or change port in application.properties
server.port=8081
```

### Can't login
- Check username/password are correct
- Check console for errors
- Verify test user was created (look for "✅ Test user created!")

### Page not found
- Make sure templates are in `src/main/resources/templates/`
- Check controller mappings
- Restart the application

## Resources to Learn More

- [Spring Security Docs](https://spring.io/projects/spring-security)
- [Spring Boot Guides](https://spring.io/guides)
- [Thymeleaf Docs](https://www.thymeleaf.org/documentation.html)
- [Baeldung Spring Security](https://www.baeldung.com/security-spring)

## Questions?

Feel free to experiment! Try:
- Changing the colors in login.html
- Adding more fields to the User model
- Creating additional pages
- Adding more test users in DataInitializer.java

Happy coding! 🚀
