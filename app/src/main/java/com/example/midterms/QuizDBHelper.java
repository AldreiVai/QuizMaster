package com.example.midterms;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class QuizDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "quiz.db";
    private static final int DATABASE_VERSION = 5;

    private static final String TABLE_COMPUTER_EASY_QUESTIONS = "computer_easy_questions";
    private static final String TABLE_COMPUTER_MEDIUM_QUESTIONS = "computer_medium_questions";
    private static final String TABLE_COMPUTER_HARD_QUESTIONS = "computer_hard_questions";
    private static final String TABLE_TRIVIA_EASY_QUESTIONS = "trivia_easy_questions";
    private static final String TABLE_TRIVIA_MEDIUM_QUESTIONS = "trivia_medium_questions";
    private static final String TABLE_TRIVIA_HARD_QUESTIONS = "trivia_hard_questions";
    private static final String TABLE_MUSIC_EASY_QUESTIONS = "music_easy_questions";
    private static final String TABLE_MUSIC_MEDIUM_QUESTIONS = "music_medium_questions";
    private static final String TABLE_MUSIC_HARD_QUESTIONS = "music_hard_questions";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_QUESTION = "question";
    private static final String COLUMN_OPTION1 = "option1";
    private static final String COLUMN_OPTION2 = "option2";
    private static final String COLUMN_OPTION3 = "option3";
    private static final String COLUMN_OPTION4 = "option4";
    private static final String COLUMN_CORRECT_ANSWER = "correctAnswer";

    public QuizDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_COMPUTER_EASY_QUESTIONS_TABLE = "CREATE TABLE " + TABLE_COMPUTER_EASY_QUESTIONS +
                "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_QUESTION + " TEXT," +
                COLUMN_OPTION1 + " TEXT," +
                COLUMN_OPTION2 + " TEXT," +
                COLUMN_OPTION3 + " TEXT," +
                COLUMN_OPTION4 + " TEXT," +
                COLUMN_CORRECT_ANSWER + " TEXT" +
                ")";
        db.execSQL(CREATE_COMPUTER_EASY_QUESTIONS_TABLE);

        String INSERT_COMPUTER_EASY_QUESTIONS = "INSERT INTO " + TABLE_COMPUTER_EASY_QUESTIONS +
                "(" + COLUMN_QUESTION + "," + COLUMN_OPTION1 + "," + COLUMN_OPTION2 + "," +
                COLUMN_OPTION3 + "," + COLUMN_OPTION4 + "," + COLUMN_CORRECT_ANSWER + ") VALUES ";

        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What does CPU stand for?', 'Central Processing Unit', 'Central Process Unit', 'Computer Personal Unit', 'Central Processor Unit', 'Central Processing Unit')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the primary purpose of an operating system?', 'To manage computer hardware and software resources', 'To browse the internet', 'To create documents', 'To play games', 'To manage computer hardware and software resources')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is RAM short for?', 'Random Access Memory', 'Read-Only Memory', 'Random Available Memory', 'Random Allocation Memory', 'Random Access Memory')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the binary equivalent of the decimal number 10?', '1010', '1100', '1110', '1001', '1010')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What does HTML stand for?', 'Hypertext Markup Language', 'Hyperloop Markup Language', 'Home Tool Markup Language', 'Hyperlink Markup Language', 'Hypertext Markup Language')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the file extension for a Microsoft Word document?', '.docx', '.xlsx', '.pptx', '.pdf', '.docx')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the purpose of a CPU?', 'To perform arithmetic and logical operations', 'To store data', 'To display images on the screen', 'To connect to the internet', 'To perform arithmetic and logical operations')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the purpose of a GPU?', 'To render graphics and images', 'To perform calculations', 'To manage memory', 'To control input and output devices', 'To render graphics and images')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the full form of URL?', 'Uniform Resource Locator', 'Universal Resource Locator', 'Uniform Resource Link', 'Universal Resource Link', 'Uniform Resource Locator')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the purpose of a firewall?', 'To protect a computer network from unauthorized access', 'To clean the computer screen', 'To boost internet speed', 'To create backups', 'To protect a computer network from unauthorized access')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the purpose of an IP address?', 'To uniquely identify a device on a network', 'To store files and documents', 'To protect against viruses', 'To control computer peripherals', 'To uniquely identify a device on a network')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the purpose of a DNS server?', 'To translate domain names to IP addresses', 'To store email messages', 'To provide internet connectivity', 'To protect against malware', 'To translate domain names to IP addresses')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the difference between a virus and malware?', 'A virus is a specific type of malware', 'Malware is more harmful than a virus', 'A virus only affects hardware, while malware affects software', 'A virus requires user interaction to spread, while malware can spread automatically', 'A virus is a specific type of malware')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the purpose of a virtual machine?', 'To run multiple operating systems on a single physical machine', 'To create virtual reality environments', 'To improve internet speed', 'To protect against hackers', 'To run multiple operating systems on a single physical machine')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What does USB stand for?', 'Universal Serial Bus', 'United States of America Standard Business', 'User System Bridge', 'Universal Storage Block', 'Universal Serial Bus')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the purpose of a router?', 'To connect multiple devices to a network and route network traffic', 'To store files and folders', 'To control computer peripherals', 'To provide electricity to a computer', 'To connect multiple devices to a network and route network traffic')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the purpose of an antivirus software?', 'To detect and remove malicious software', 'To enhance computer performance', 'To create new software applications', 'To organize files and folders', 'To detect and remove malicious software')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the purpose of a spreadsheet software?', 'To organize and analyze data', 'To design graphics and images', 'To create and edit videos', 'To browse the internet', 'To organize and analyze data')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the purpose of a compiler?', 'To translate high-level programming code into machine code', 'To manage computer memory', 'To create graphical user interfaces', 'To control computer peripherals', 'To translate high-level programming code into machine code')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the purpose of a modem?', 'To connect a computer to the internet', 'To print documents', 'To store data', 'To play audio files', 'To connect a computer to the internet')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the purpose of a web browser?', 'To access and view websites', 'To perform complex calculations', 'To create databases', 'To edit images', 'To access and view websites')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the purpose of a cache?', 'To store frequently accessed data for faster retrieval', 'To encrypt data', 'To create backups', 'To connect to wireless networks', 'To store frequently accessed data for faster retrieval')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the purpose of an SSD?', 'To store data in a non-volatile manner', 'To connect multiple devices to a network', 'To enhance screen resolution', 'To boost computer performance', 'To store data in a non-volatile manner')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the purpose of a network switch?', 'To connect multiple devices in a local area network', 'To scan for viruses', 'To create backups', 'To play audio files', 'To connect multiple devices in a local area network')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the purpose of a backup?', 'To create a copy of important data for recovery purposes', 'To format a hard drive', 'To browse the internet', 'To improve computer speed', 'To create a copy of important data for recovery purposes')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the purpose of an input device?', 'To provide data and instructions to a computer', 'To display images on the screen', 'To protect against malware', 'To create backups', 'To provide data and instructions to a computer')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the purpose of an output device?', 'To present processed data to the user', 'To store files and folders', 'To connect to wireless networks', 'To control computer peripherals', 'To present processed data to the user')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the purpose of a database?', 'To store and manage structured data', 'To create computer programs', 'To provide internet connectivity', 'To clean the computer screen', 'To store and manage structured data')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the purpose of a programming language?', 'To create instructions for a computer to follow', 'To connect to the internet', 'To play games', 'To create backups', 'To create instructions for a computer to follow')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the purpose of a loop in programming?', 'To repeat a set of instructions', 'To organize files and folders', 'To browse the internet', 'To control computer peripherals', 'To repeat a set of instructions')");
        db.execSQL(INSERT_COMPUTER_EASY_QUESTIONS + "('What is the purpose of a conditional statement in programming?', 'To perform different actions based on a condition', 'To store and manage structured data', 'To provide internet connectivity', 'To clean the computer screen', 'To perform different actions based on a condition')");

        String CREATE_COMPUTER_MEDIUM_QUESTIONS_TABLE = "CREATE TABLE " + TABLE_COMPUTER_MEDIUM_QUESTIONS +
                "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_QUESTION + " TEXT," +
                COLUMN_OPTION1 + " TEXT," +
                COLUMN_OPTION2 + " TEXT," +
                COLUMN_OPTION3 + " TEXT," +
                COLUMN_OPTION4 + " TEXT," +
                COLUMN_CORRECT_ANSWER + " TEXT" +
                ")";
        db.execSQL(CREATE_COMPUTER_MEDIUM_QUESTIONS_TABLE);

        String INSERT_COMPUTER_MEDIUM_QUESTIONS = "INSERT INTO " + TABLE_COMPUTER_MEDIUM_QUESTIONS +
                "(" + COLUMN_QUESTION + "," + COLUMN_OPTION1 + "," + COLUMN_OPTION2 + "," +
                COLUMN_OPTION3 + "," + COLUMN_OPTION4 + "," + COLUMN_CORRECT_ANSWER + ") VALUES ";

        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('What is the basic unit of digital information in computing?', 'Byte', 'Bit', 'Nibble', 'Megabyte', 'Bit')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('Which programming language is often used for developing Android apps?', 'Java', 'Python', 'C++', 'Ruby', 'Java')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('What does CPU stand for?', 'Central Processing Unit', 'Computer Processing Unit', 'Control Processing Unit', 'Central Program Unit', 'Central Processing Unit')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('Which company developed the first graphical user interface (GUI)?', 'Apple', 'Microsoft', 'IBM', 'Xerox', 'Xerox')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('What is the full form of HTML?', 'Hypertext Markup Language', 'Hyperlinks and Text Markup Language', 'Home Tool Markup Language', 'Hypertext Machine Language', 'Hypertext Markup Language')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('Which protocol is used to send email over the Internet?', 'FTP', 'HTTP', 'SMTP', 'SSH', 'SMTP')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('What does CSS stand for in web development?', 'Cascading Style Sheets', 'Creative Style Sheets', 'Computer Style Sheets', 'Colorful Style Sheets', 'Cascading Style Sheets')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('Which programming language is often used for data analysis and scientific computing?', 'Java', 'Ruby', 'Python', 'C#', 'Python')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('What does RAID stand for in data storage?', 'Redundant Array of Independent Disks', 'Random Access and Independent Disks', 'Rapid Array of Integrated Disks', 'Reliable Array of Internal Disks', 'Redundant Array of Independent Disks')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('Which company developed the Python programming language?', 'Google', 'Microsoft', 'Apple', 'Python Software Foundation', 'Python Software Foundation')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('What is the process of converting source code into machine code called?', 'Compiling', 'Debugging', 'Interpreting', 'Linking', 'Compiling')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('Which protocol is used for secure communication over the Internet?', 'SMTP', 'FTP', 'HTTP', 'HTTPS', 'HTTPS')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('What does SQL stand for in database management?', 'Structured Query Language', 'Standard Query Language', 'Sequential Query Language', 'Structured Question Language', 'Structured Query Language')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('Which data structure operates on a \"first in, first out\" (FIFO) principle?', 'Stack', 'Heap', 'Queue', 'Tree', 'Queue')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('What does the acronym API stand for in software development?', 'Application Programming Interface', 'Application Program Interface', 'Application Protocol Interface', 'Advanced Program Interface', 'Application Programming Interface')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('Which company developed the C programming language?', 'Google', 'Microsoft', 'Apple', 'Bell Labs', 'Bell Labs')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('What does DNS stand for in networking?', 'Domain Name Service', 'Digital Network System', 'Dynamic Naming System', 'Data Network Service', 'Domain Name Service')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('Which component of a computer is responsible for executing instructions?', 'Memory', 'Hard Drive', 'Motherboard', 'CPU', 'CPU')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('What does the acronym URL stand for in web addresses?', 'Uniform Resource Locator', 'Universal Resource Language', 'Uniform Reference Locator', 'Universal Reference Language', 'Uniform Resource Locator')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('Which programming language is often used for game development?', 'JavaScript', 'C#', 'Swift', 'HTML', 'C#')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('What does VPN stand for in network security?', 'Virtual Private Network', 'Virtual Personal Network', 'Verified Private Network', 'Visual Private Network', 'Virtual Private Network')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('What is the primary function of an operating system?', 'Running applications', 'Managing hardware resources', 'Creating user interfaces', 'Managing databases', 'Managing hardware resources')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('Which programming language is often used for web development?', 'Java', 'Python', 'C++', 'JavaScript', 'JavaScript')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('What does GPU stand for in computer graphics?', 'Graphical Processing Unit', 'General Processing Unit', 'Graphical Performance Unit', 'General Performance Unit', 'Graphical Processing Unit')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('Which company developed the Java programming language?', 'Google', 'Microsoft', 'Oracle', 'Apple', 'Oracle')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('What does IDE stand for in software development?', 'Integrated Development Environment', 'Interactive Development Environment', 'Integrated Design Environment', 'Interactive Design Environment', 'Integrated Development Environment')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('What is the process of finding and fixing errors in a program called?', 'Compiling', 'Debugging', 'Interpreting', 'Linking', 'Debugging')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('Which programming language is often used for artificial intelligence (AI) applications?', 'Java', 'Ruby', 'Python', 'C#', 'Python')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('What does FTP stand for in file transfer?', 'File Transfer Protocol', 'Fast Transfer Protocol', 'Flexible Transfer Protocol', 'File Transmission Protocol', 'File Transfer Protocol')");
        db.execSQL(INSERT_COMPUTER_MEDIUM_QUESTIONS + "('Which company developed the C++ programming language?', 'Google', 'Microsoft', 'Apple', 'Bell Labs', 'Bell Labs')");

        String CREATE_COMPUTER_HARD_QUESTIONS_TABLE = "CREATE TABLE " + TABLE_COMPUTER_HARD_QUESTIONS +
                "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_QUESTION + " TEXT," +
                COLUMN_OPTION1 + " TEXT," +
                COLUMN_OPTION2 + " TEXT," +
                COLUMN_OPTION3 + " TEXT," +
                COLUMN_OPTION4 + " TEXT," +
                COLUMN_CORRECT_ANSWER + " TEXT" +
                ")";
        db.execSQL(CREATE_COMPUTER_HARD_QUESTIONS_TABLE);

        String INSERT_COMPUTER_HARD_QUESTIONS = "INSERT INTO " + TABLE_COMPUTER_HARD_QUESTIONS +
                "(" + COLUMN_QUESTION + "," + COLUMN_OPTION1 + "," + COLUMN_OPTION2 + "," +
                COLUMN_OPTION3 + "," + COLUMN_OPTION4 + "," + COLUMN_CORRECT_ANSWER + ") VALUES ";

        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('What is the maximum number of IP addresses that can be assigned to a single network interface?', '256', '512', '1024', '65536', '65536')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('What is the smallest unit of information in quantum computing?', 'Quantum Bit (Qubit)', 'Quantum Byte (Qubyte)', 'Quantum Nibble (Qnibble)', 'Quantum Megabit (Qmegabit)', 'Quantum Bit (Qubit)')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('Which programming paradigm focuses on breaking a complex problem into smaller subproblems and solving them recursively?', 'Object-Oriented Programming', 'Procedural Programming', 'Functional Programming', 'Recursive Programming', 'Functional Programming')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('What is the purpose of a Bloom filter in computer science?', 'Cryptography', 'Compression', 'Database Indexing', 'Error Correction', 'Database Indexing')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('In computer graphics, what does the term anti-aliasing refer to?', 'Removing aliasing artifacts', 'Creating aliasing artifacts', 'Smoothing out textures', 'Enhancing brightness and contrast', 'Removing aliasing artifacts')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('Which data structure allows for efficient insertion, deletion, and retrieval of the smallest or largest element?', 'Heap', 'Stack', 'Queue', 'Tree', 'Heap')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('What is the maximum number of nodes in a binary tree of height h?', '2^h', 'h^2', 'h!', '2h', '2^h')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('Which algorithm is used to find the shortest path in a weighted graph?', 'Depth-First Search (DFS)', 'Breadth-First Search (BFS)', 'Dijkstras Algorithm', 'A* Algorithm', 'Dijkstras Algorithm')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('In computer networking, what does the term MTU stand for?', 'Maximum Transmission Unit', 'Minimum Transfer Unit', 'Maximum Transport Unit', 'Minimum Transmission Unit', 'Maximum Transmission Unit')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('What does the term Big O notation represent in algorithm analysis?', 'Best-case runtime complexity', 'Average-case runtime complexity', 'Worst-case runtime complexity', 'Average-case space complexity', 'Worst-case runtime complexity')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('What is the process of converting high-level programming code into machine code without an intermediate step called?', 'Compiling', 'Interpreting', 'Transpiling', 'Decompiling', 'Interpreting')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('Which encryption algorithm is widely used for securing wireless networks?', 'AES', 'DES', 'RSA', 'SHA', 'AES')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('What is the term for the phenomenon when a computer processor performs better than expected due to optimizations in the instruction pipeline?', 'Out-of-order execution', 'Branch prediction', 'Pipelining', 'Instruction-level parallelism', 'Out-of-order execution')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('Which algorithm is used for key exchange and establishing secure communication over an insecure channel?', 'Diffie-Hellman', 'RSA', 'AES', 'SHA', 'Diffie-Hellman')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('In computer vision, what does the term SIFT stand for?', 'Scale-Invariant Feature Transform', 'Segmented Image Filtering Technique', 'Sequential Image Feature Tracking', 'Selective Information Filtering Technology', 'Scale-Invariant Feature Transform')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('Which data structure is used in depth-first search (DFS) and breadth-first search (BFS) algorithms?', 'Stack', 'Heap', 'Queue', 'Tree', 'Stack')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('What does the term denial-of-service (DoS) refer to in computer security?', 'Unauthorized access to a system', 'Stealing sensitive information', 'Disrupting availability of a system', 'Injecting malicious code into a system', 'Disrupting availability of a system')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('Which database model uses a graph structure to represent relationships between entities?', 'Relational database', 'Hierarchical database', 'Network database', 'Graph database', 'Graph database')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('What is the purpose of the HAL layer in the Android operating system?', 'Managing hardware resources', 'Handling user interfaces', 'Interacting with network protocols', 'Securing data storage', 'Managing hardware resources')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('Which algorithm is used for content-addressable storage and data retrieval in distributed systems?', 'SHA-1', 'MD5', 'Bloom filter', 'Consistent hashing', 'Consistent hashing')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('In computer graphics, what does the term ray tracing refer to?', 'Rendering shadows and reflections', 'Creating vector-based images', 'Generating 3D models', 'Mapping textures onto surfaces', 'Rendering shadows and reflections')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('What does the CAP theorem state about distributed systems?', 'Consistency, Availability, and Partition tolerance are mutually exclusive', 'Consistency, Accessibility, and Partition tolerance are mutually exclusive', 'Consistency, Availability, and Performance are mutually exclusive', 'Consistency, Accessibility, and Performance are mutually exclusive', 'Consistency, Availability, and Partition tolerance are mutually exclusive')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('Which algorithm is used for pattern matching and string searching?', 'Dijkstras Algorithm', 'A* Algorithm', 'Knuth-Morris-Pratt Algorithm', 'Prims Algorithm', 'Knuth-Morris-Pratt Algorithm')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('What is the primary function of a compiler?', 'Executing program instructions', 'Translating high-level code into machine code', 'Managing memory resources', 'Enforcing access control policies', 'Translating high-level code into machine code')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('Which cryptographic hash function is widely used for data integrity checks?', 'AES', 'DES', 'RSA', 'SHA-256', 'SHA-256')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('In parallel computing, what does Amdahls law state?', 'The overall speedup of a program depends on the speedup of the parallelizable portion', 'The performance of a program is limited by the sequential portion', 'The performance of a program improves linearly with the number of processors', 'The overall speedup of a program is always equal to the speedup of the parallelizable portion', 'The overall speedup of a program depends on the speedup of the parallelizable portion')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('What is the term for a programming language feature that allows a function to have different forms based on the number or types of arguments?', 'Polymorphism', 'Inheritance', 'Encapsulation', 'Abstraction', 'Polymorphism')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('Which algorithm is used for clustering and unsupervised machine learning?', 'K-means', 'Decision tree', 'Support vector machine', 'Naive Bayes', 'K-means')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('What is the purpose of the HAL layer in the Android operating system?', 'Managing hardware resources', 'Handling user interfaces', 'Interacting with network protocols', 'Securing data storage', 'Managing hardware resources')");
        db.execSQL(INSERT_COMPUTER_HARD_QUESTIONS + "('What does the term race condition refer to in concurrent programming?', 'A situation where multiple processes access shared data simultaneously and the outcome depends on the order of execution', 'A situation where a program enters an infinite loop and consumes excessive resources', 'A situation where a program crashes due to insufficient memory', 'A situation where a program fails to handle exceptions properly and crashes', 'A situation where multiple processes access shared data simultaneously and the outcome depends on the order of execution')");

        String CREATE_TRIVIA_EASY_QUESTIONS_TABLE = "CREATE TABLE " + TABLE_TRIVIA_EASY_QUESTIONS +
                "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_QUESTION + " TEXT," +
                COLUMN_OPTION1 + " TEXT," +
                COLUMN_OPTION2 + " TEXT," +
                COLUMN_OPTION3 + " TEXT," +
                COLUMN_OPTION4 + " TEXT," +
                COLUMN_CORRECT_ANSWER + " TEXT" +
                ")";
        db.execSQL(CREATE_TRIVIA_EASY_QUESTIONS_TABLE);

        String INSERT_TRIVIA_EASY_QUESTIONS = "INSERT INTO " + TABLE_TRIVIA_EASY_QUESTIONS +
                "(" + COLUMN_QUESTION + "," + COLUMN_OPTION1 + "," + COLUMN_OPTION2 + "," +
                COLUMN_OPTION3 + "," + COLUMN_OPTION4 + "," + COLUMN_CORRECT_ANSWER + ") VALUES ";
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('What is the capital of France?', 'Paris', 'London', 'Madrid', 'Berlin', 'Paris')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('Which planet is known as the Red Planet?', 'Mars', 'Jupiter', 'Venus', 'Saturn', 'Mars')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('Who painted the Mona Lisa?', 'Leonardo da Vinci', 'Pablo Picasso', 'Vincent van Gogh', 'Michelangelo', 'Leonardo da Vinci')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('Which animal is known as the King of the Jungle?', 'Lion', 'Tiger', 'Elephant', 'Giraffe', 'Lion')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('What is the tallest mountain in the world?', 'Mount Everest', 'K2', 'Kangchenjunga', 'Makalu', 'Mount Everest')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('Who wrote the play Romeo and Juliet?', 'William Shakespeare', 'Charles Dickens', 'Jane Austen', 'Mark Twain', 'William Shakespeare')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('Which country is famous for the Taj Mahal?', 'India', 'China', 'Egypt', 'Italy', 'India')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('What is the largest ocean in the world?', 'Pacific Ocean', 'Atlantic Ocean', 'Indian Ocean', 'Arctic Ocean', 'Pacific Ocean')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('Who is the main protagonist in the Harry Potter book series?', 'Harry Potter', 'Ron Weasley', 'Hermione Granger', 'Albus Dumbledore', 'Harry Potter')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('What is the chemical symbol for gold?', 'Au', 'Ag', 'Fe', 'Cu', 'Au')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('Which city hosted the 2016 Summer Olympics?', 'Rio de Janeiro', 'London', 'Beijing', 'Tokyo', 'Rio de Janeiro')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('What is the largest planet in our solar system?', 'Jupiter', 'Saturn', 'Mars', 'Neptune', 'Jupiter')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('Who is the author of the Harry Potter book series?', 'J.K. Rowling', 'Stephen King', 'George R.R. Martin', 'Dan Brown', 'J.K. Rowling')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('Which instrument has 88 keys?', 'Piano', 'Guitar', 'Violin', 'Flute', 'Piano')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('What is the primary language spoken in Brazil?', 'Portuguese', 'Spanish', 'English', 'French', 'Portuguese')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('What is the symbol for the chemical element oxygen?', 'O', 'H', 'C', 'N', 'O')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('Who is the lead vocalist of the band Queen?', 'Freddie Mercury', 'John Lennon', 'Mick Jagger', 'David Bowie', 'Freddie Mercury')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('Which country is known for its famous pyramids?', 'Egypt', 'Mexico', 'Italy', 'China', 'Egypt')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('What is the largest land animal?', 'Elephant', 'Giraffe', 'Hippopotamus', 'Rhinoceros', 'Elephant')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('Who painted the famous artwork The Starry Night?', 'Vincent van Gogh', 'Pablo Picasso', 'Leonardo da Vinci', 'Salvador Dali', 'Vincent van Gogh')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('What is the currency of Japan?', 'Yen', 'Euro', 'Dollar', 'Pound', 'Yen')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('Which continent is known as the Dark Continent?', 'Africa', 'Asia', 'Europe', 'South America', 'Africa')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('Who is the current President of the United States?', 'Joe Biden', 'Donald Trump', 'Barack Obama', 'George W. Bush', 'Joe Biden')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('What is the largest organ in the human body?', 'Skin', 'Heart', 'Liver', 'Brain', 'Skin')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('Which planet is known as the Blue Planet?', 'Earth', 'Mars', 'Venus', 'Jupiter', 'Earth')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('Who wrote the novel Pride and Prejudice?', 'Jane Austen', 'Emily Bronte', 'Charlotte Bronte', 'Virginia Woolf', 'Jane Austen')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('What is the chemical symbol for carbon?', 'C', 'Ca', 'Co', 'Cu', 'C')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('Which country is famous for the Great Wall?', 'China', 'India', 'Russia', 'Italy', 'China')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('Who painted the famous artwork The Last Supper?', 'Leonardo da Vinci', 'Pablo Picasso', 'Vincent van Gogh', 'Michelangelo', 'Leonardo da Vinci')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('Which animal is known as the Gentle Giant?', 'Elephant', 'Giraffe', 'Hippopotamus', 'Rhinoceros', 'Elephant')");
        db.execSQL(INSERT_TRIVIA_EASY_QUESTIONS + "('What is the largest waterfall in the world?', 'Angel Falls', 'Niagara Falls', 'Victoria Falls', 'Iguazu Falls', 'Angel Falls')");

        String CREATE_TRIVIA_MEDIUM_QUESTIONS_TABLE = "CREATE TABLE " + TABLE_TRIVIA_MEDIUM_QUESTIONS +
                "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_QUESTION + " TEXT," +
                COLUMN_OPTION1 + " TEXT," +
                COLUMN_OPTION2 + " TEXT," +
                COLUMN_OPTION3 + " TEXT," +
                COLUMN_OPTION4 + " TEXT," +
                COLUMN_CORRECT_ANSWER + " TEXT" +
                ")";
        db.execSQL(CREATE_TRIVIA_MEDIUM_QUESTIONS_TABLE);

        String INSERT_TRIVIA_MEDIUM_QUESTIONS = "INSERT INTO " + TABLE_TRIVIA_MEDIUM_QUESTIONS +
                "(" + COLUMN_QUESTION + "," + COLUMN_OPTION1 + "," + COLUMN_OPTION2 + "," +
                COLUMN_OPTION3 + "," + COLUMN_OPTION4 + "," + COLUMN_CORRECT_ANSWER + ") VALUES ";
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('Who is the author of the famous novel ''To Kill a Mockingbird''?', 'Harper Lee', 'F. Scott Fitzgerald', 'Ernest Hemingway', 'J.D. Salinger', 'Harper Lee');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('Which country is known as the ''Land of the Rising Sun''?', 'Japan', 'China', 'South Korea', 'Vietnam', 'Japan');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('Who is the artist behind the famous painting ''The Persistence of Memory''?', 'Salvador Dali', 'Pablo Picasso', 'Vincent van Gogh', 'Leonardo da Vinci', 'Salvador Dali');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('What is the largest desert in the world?', 'Sahara Desert', 'Gobi Desert', 'Atacama Desert', 'Arabian Desert', 'Sahara Desert');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('Which country is home to the famous landmark Machu Picchu?', 'Peru', 'Mexico', 'Argentina', 'Chile', 'Peru');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('Who wrote the famous novel ''1984''?', 'George Orwell', 'Ray Bradbury', 'Aldous Huxley', 'Margaret Atwood', 'George Orwell');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('What is the largest species of shark?', 'Whale Shark', 'Great White Shark', 'Tiger Shark', 'Hammerhead Shark', 'Whale Shark');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('Which famous physicist developed the theory of relativity?', 'Albert Einstein', 'Isaac Newton', 'Niels Bohr', 'Stephen Hawking', 'Albert Einstein');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('What is the largest animal on Earth?', 'Blue Whale', 'Elephant', 'Giraffe', 'Hippopotamus', 'Blue Whale');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('Who is the author of the ''Lord of the Rings'' book series?', 'J.R.R. Tolkien', 'C.S. Lewis', 'J.K. Rowling', 'George R.R. Martin', 'J.R.R. Tolkien');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('Which country is known as the ''Land of Fire and Ice''?', 'Iceland', 'Greenland', 'Canada', 'New Zealand', 'Iceland');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('Who painted the famous artwork ''The Scream''?', 'Edvard Munch', 'Pablo Picasso', 'Vincent van Gogh', 'Claude Monet', 'Edvard Munch');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('What is the longest river in the world?', 'Nile River', 'Amazon River', 'Yangtze River', 'Mississippi River', 'Nile River');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('Who wrote the novel ''The Catcher in the Rye''?', 'J.D. Salinger', 'F. Scott Fitzgerald', 'Mark Twain', 'John Steinbeck', 'J.D. Salinger');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('Which country is famous for the Angkor Wat temple complex?', 'Cambodia', 'Thailand', 'Vietnam', 'Laos', 'Cambodia');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('Who is the artist behind the famous painting ''The Mona Lisa''?', 'Leonardo da Vinci', 'Pablo Picasso', 'Vincent van Gogh', 'Michelangelo', 'Leonardo da Vinci');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('What is the capital city of Australia?', 'Canberra', 'Sydney', 'Melbourne', 'Brisbane', 'Canberra');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('Which country is known as the ''Land of Smiles''?', 'Thailand', 'India', 'Indonesia', 'Brazil', 'Thailand');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('Who is the author of the ''Harry Potter'' book series?', 'J.K. Rowling', 'George R.R. Martin', 'Stephenie Meyer', 'Suzanne Collins', 'J.K. Rowling');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('What is the tallest mountain in the world?', 'Mount Everest', 'K2', 'Kangchenjunga', 'Makalu', 'Mount Everest');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('Who is the author of the famous play ''Romeo and Juliet''?', 'William Shakespeare', 'Arthur Miller', 'Anton Chekhov', 'Samuel Beckett', 'William Shakespeare');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('What is the capital city of Canada?', 'Ottawa', 'Toronto', 'Montreal', 'Vancouver', 'Ottawa');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('Which country is known for its tulip fields?', 'Netherlands', 'France', 'Italy', 'Germany', 'Netherlands');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('Who painted the famous artwork ''The Creation of Adam''?', 'Michelangelo', 'Pablo Picasso', 'Vincent van Gogh', 'Leonardo da Vinci', 'Michelangelo');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('What is the official language of Brazil?', 'Portuguese', 'Spanish', 'French', 'Italian', 'Portuguese');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('Which country is known for its delicious sushi?', 'Japan', 'China', 'Thailand', 'South Korea', 'Japan');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('Who is the author of the famous novel ''The Great Gatsby''?', 'F. Scott Fitzgerald', 'Ernest Hemingway', 'Mark Twain', 'Harper Lee', 'F. Scott Fitzgerald');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('What is the largest reef system in the world?', 'Great Barrier Reef', 'Belize Barrier Reef', 'Maldives Coral Reef', 'Florida Reef', 'Great Barrier Reef');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('Who is the artist behind the famous painting ''The Starry Night''?', 'Vincent van Gogh', 'Salvador Dali', 'Pablo Picasso', 'Leonardo da Vinci', 'Vincent van Gogh');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('What is the currency of Brazil?', 'Real', 'Peso', 'Euro', 'Yen', 'Real');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('Which country is known for the ancient city of Petra?', 'Jordan', 'Egypt', 'Greece', 'Turkey', 'Jordan');");
        db.execSQL(INSERT_TRIVIA_MEDIUM_QUESTIONS + "('Who wrote the famous novel ''Pride and Prejudice''?', 'Jane Austen', 'Charlotte Bronte', 'Emily Bronte', 'Virginia Woolf', 'Jane Austen');");

        String CREATE_TRIVIA_HARD_QUESTIONS_TABLE = "CREATE TABLE " + TABLE_TRIVIA_HARD_QUESTIONS +
                "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_QUESTION + " TEXT," +
                COLUMN_OPTION1 + " TEXT," +
                COLUMN_OPTION2 + " TEXT," +
                COLUMN_OPTION3 + " TEXT," +
                COLUMN_OPTION4 + " TEXT," +
                COLUMN_CORRECT_ANSWER + " TEXT" +
                ")";
        db.execSQL(CREATE_TRIVIA_HARD_QUESTIONS_TABLE);

        String INSERT_TRIVIA_HARD_QUESTIONS = "INSERT INTO " + TABLE_TRIVIA_HARD_QUESTIONS +
                "(" + COLUMN_QUESTION + "," + COLUMN_OPTION1 + "," + COLUMN_OPTION2 + "," +
                COLUMN_OPTION3 + "," + COLUMN_OPTION4 + "," + COLUMN_CORRECT_ANSWER + ") VALUES ";
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('What is the longest river in Africa?', 'Nile River', 'Congo River', 'Zambezi River', 'Niger River', 'Nile River');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Who is the author of the book ''To Kill a Mockingbird''?', 'Harper Lee', 'J.D. Salinger', 'George Orwell', 'F. Scott Fitzgerald', 'Harper Lee');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Which country is the largest producer of coffee in the world?', 'Brazil', 'Colombia', 'Vietnam', 'Ethiopia', 'Brazil');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('In which year did World War I begin?', '1914', '1918', '1939', '1945', '1914');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Who was the first woman to win a Nobel Prize?', 'Marie Curie', 'Rosalind Franklin', 'Dorothy Hodgkin', 'Ada Lovelace', 'Marie Curie');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Which planet is known as the ''Red Planet''?', 'Mars', 'Jupiter', 'Saturn', 'Neptune', 'Mars');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Who is the author of the book ''1984''?', 'George Orwell', 'Aldous Huxley', 'Ray Bradbury', 'Arthur C. Clarke', 'George Orwell');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Which country is known for its fjords?', 'Norway', 'New Zealand', 'Canada', 'Iceland', 'Norway');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Who discovered the theory of general relativity?', 'Albert Einstein', 'Isaac Newton', 'Stephen Hawking', 'Galileo Galilei', 'Albert Einstein');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('What is the chemical symbol for gold?', 'Au', 'Ag', 'Cu', 'Fe', 'Au');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Which artist painted the ceiling of the Sistine Chapel?', 'Michelangelo', 'Leonardo da Vinci', 'Raphael', 'Donatello', 'Michelangelo');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('In which city is the headquarters of the United Nations located?', 'New York City', 'London', 'Geneva', 'Paris', 'New York City');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Which country is home to the tallest building in the world, the Burj Khalifa?', 'United Arab Emirates', 'China', 'United States', 'Saudi Arabia', 'United Arab Emirates');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Who painted the famous artwork ''The Last Supper''?', 'Leonardo da Vinci', 'Vincent van Gogh', 'Pablo Picasso', 'Claude Monet', 'Leonardo da Vinci');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Which country is known for its wildlife safaris?', 'Kenya', 'Tanzania', 'South Africa', 'Botswana', 'Kenya');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Who is the author of the book ''The Catcher in the Rye''?', 'J.D. Salinger', 'Ernest Hemingway', 'F. Scott Fitzgerald', 'Mark Twain', 'J.D. Salinger');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Which planet is the smallest in our solar system?', 'Mercury', 'Pluto', 'Mars', 'Venus', 'Mercury');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Who was the first person to step on the moon?', 'Neil Armstrong', 'Buzz Aldrin', 'Yuri Gagarin', 'John Glenn', 'Neil Armstrong');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Which country is known for its tulips and windmills?', 'Netherlands', 'Belgium', 'Denmark', 'Sweden', 'Netherlands');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Who is the author of the book ''The Great Gatsby''?', 'F. Scott Fitzgerald', 'Ernest Hemingway', 'William Shakespeare', 'George Orwell', 'F. Scott Fitzgerald');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Which country is known for its historical ruins of Machu Picchu?', 'Peru', 'Mexico', 'Brazil', 'Argentina', 'Peru');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Who painted the famous artwork ''Starry Night''?', 'Vincent van Gogh', 'Leonardo da Vinci', 'Pablo Picasso', 'Claude Monet', 'Vincent van Gogh');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Which country is known for its pyramids, including the Pyramid of Giza?', 'Egypt', 'Greece', 'China', 'Mexico', 'Egypt');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Who is the author of the book ''Moby-Dick''?', 'Herman Melville', 'Mark Twain', 'Charles Dickens', 'Emily Bronte', 'Herman Melville');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Which country is known as the ''Land of the Rising Sun''?', 'Japan', 'China', 'South Korea', 'India', 'Japan');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Who discovered penicillin?', 'Alexander Fleming', 'Marie Curie', 'Louis Pasteur', 'Gregor Mendel', 'Alexander Fleming');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Which country is known for its famous carnival celebration in Rio de Janeiro?', 'Brazil', 'Spain', 'Italy', 'France', 'Brazil');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Who is the author of the book ''The Odyssey''?', 'Homer', 'Virgil', 'Plato', 'Aristotle', 'Homer');");
        db.execSQL(INSERT_TRIVIA_HARD_QUESTIONS + "('Which country is known for its beautiful beaches in Bali?', 'Indonesia', 'Thailand', 'Malaysia', 'Philippines', 'Indonesia');");

        String CREATE_MUSIC_EASY_QUESTIONS_TABLE = "CREATE TABLE " + TABLE_MUSIC_EASY_QUESTIONS +
                "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_QUESTION + " TEXT," +
                COLUMN_OPTION1 + " TEXT," +
                COLUMN_OPTION2 + " TEXT," +
                COLUMN_OPTION3 + " TEXT," +
                COLUMN_OPTION4 + " TEXT," +
                COLUMN_CORRECT_ANSWER + " TEXT" +
                ")";
        db.execSQL(CREATE_MUSIC_EASY_QUESTIONS_TABLE);

        String INSERT_MUSIC_EASY_QUESTIONS = "INSERT INTO " + TABLE_MUSIC_EASY_QUESTIONS +
                "(" + COLUMN_QUESTION + "," + COLUMN_OPTION1 + "," + COLUMN_OPTION2 + "," +
                COLUMN_OPTION3 + "," + COLUMN_OPTION4 + "," + COLUMN_CORRECT_ANSWER + ") VALUES ";
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Which band is known for the hit song ''Hey Jude''?', 'The Beatles', 'Led Zeppelin', 'Queen', 'The Rolling Stones', 'The Beatles');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Who is the lead singer of the band Coldplay?', 'Chris Martin', 'Bono', 'Thom Yorke', 'Dave Grohl', 'Chris Martin');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Which artist released the album ''Thriller'' in 1982?', 'Michael Jackson', 'Prince', 'Madonna', 'Whitney Houston', 'Michael Jackson');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Which pop star is known as the ''Material Girl''?', 'Madonna', 'Britney Spears', 'Taylor Swift', 'Beyoncé', 'Madonna');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('What is the name of Beyoncés former group?', 'Destinys Child', 'Spice Girls', 'TLC', 'The Supremes', 'Destinys Child');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Which British band is known for the song ''Yellow''?', 'Coldplay', 'Radiohead', 'Muse', 'Arctic Monkeys', 'Coldplay');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Which artist released the album ''Born in the U.S.A.''?', 'Bruce Springsteen', 'Elvis Presley', 'Bob Dylan', 'David Bowie', 'Bruce Springsteen');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Who is known as the ''King of Pop''?', 'Michael Jackson', 'Elvis Presley', 'Stevie Wonder', 'James Brown', 'Michael Jackson');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Which female artist had a hit with the song ''Royals''?', 'Lorde', 'Adele', 'Katy Perry', 'Rihanna', 'Lorde');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Which band is known for the song ''Smells Like Teen Spirit''?', 'Nirvana', 'Guns N Roses', 'Metallica', 'Pearl Jam', 'Nirvana');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Who is the lead singer of the band U2?', 'Bono', 'Chris Martin', 'Thom Yorke', 'Dave Grohl', 'Bono');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Which artist released the album ''The Eminem Show''?', 'Eminem', 'Jay-Z', 'Kendrick Lamar', 'Drake', 'Eminem');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Who is known as the ''Queen of Soul''?', 'Aretha Franklin', 'Tina Turner', 'Whitney Houston', 'Diana Ross', 'Aretha Franklin');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Which artist released the song ''Hello'' in 2015?', 'Adele', 'Taylor Swift', 'Beyoncé', 'Rihanna', 'Adele');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Which band is known for the song ''Hotel California''?', 'Eagles', 'The Beach Boys', 'Fleetwood Mac', 'The Rolling Stones', 'Eagles');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Who is the lead singer of the band Queen?', 'Freddie Mercury', 'Robert Plant', 'Mick Jagger', 'Roger Daltrey', 'Freddie Mercury');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Which artist released the album ''Back to Black''?', 'Amy Winehouse', 'Lana Del Rey', 'Lady Gaga', 'Adele', 'Amy Winehouse');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Which female artist had a hit with the song ''Bad Guy''?', 'Billie Eilish', 'Rihanna', 'Ariana Grande', 'Katy Perry', 'Billie Eilish');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Which band is known for the song ''Sweet Child o Mine?', 'Guns N Roses', 'Nirvana', 'Metallica', 'AC/DC', 'Guns N Roses');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Who is the lead singer of the band Radiohead?', 'Thom Yorke', 'Chris Martin', 'Bono', 'Dave Grohl', 'Thom Yorke');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Which artist released the album ''Like a Prayer''?', 'Madonna', 'Britney Spears', 'Taylor Swift', 'Beyoncé', 'Madonna');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Which artist released the song ''Shape of You'' in 2017?', 'Ed Sheeran', 'Justin Bieber', 'The Weeknd', 'Shawn Mendes', 'Ed Sheeran');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Which band is known for the song ''Wonderwall''?', 'Oasis', 'The Beatles', 'The Rolling Stones', 'Coldplay', 'Oasis');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Who is known as the ''King of Rock and Roll''?', 'Elvis Presley', 'Michael Jackson', 'Stevie Wonder', 'James Brown', 'Elvis Presley');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Which female artist had a hit with the song ''Rolling in the Deep''?', 'Adele', 'Lorde', 'Katy Perry', 'Rihanna', 'Adele');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Which band is known for the song ''Bohemian Rhapsody''?', 'Queen', 'Led Zeppelin', 'The Beatles', 'The Rolling Stones', 'Queen');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Who is the lead singer of the band The Rolling Stones?', 'Mick Jagger', 'Robert Plant', 'Roger Daltrey', 'Freddie Mercury', 'Mick Jagger');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Which artist released the album ''Lemonade''?', 'Beyoncé', 'Taylor Swift', 'Madonna', 'Britney Spears', 'Beyoncé');");
        db.execSQL(INSERT_MUSIC_EASY_QUESTIONS + "('Which artist released the song ''Cant Stop the Feeling!'' in 2016?', 'Justin Timberlake', 'Bruno Mars', 'The Weeknd', 'Shawn Mendes', 'Justin Timberlake');");


        String CREATE_MUSIC_MEDIUM_QUESTIONS_TABLE = "CREATE TABLE " + TABLE_MUSIC_MEDIUM_QUESTIONS +
                "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_QUESTION + " TEXT," +
                COLUMN_OPTION1 + " TEXT," +
                COLUMN_OPTION2 + " TEXT," +
                COLUMN_OPTION3 + " TEXT," +
                COLUMN_OPTION4 + " TEXT," +
                COLUMN_CORRECT_ANSWER + " TEXT" +
                ")";
        db.execSQL(CREATE_MUSIC_MEDIUM_QUESTIONS_TABLE);
        String INSERT_MUSIC_MEDIUM_QUESTIONS = "INSERT INTO " + TABLE_MUSIC_MEDIUM_QUESTIONS +
                "(" + COLUMN_QUESTION + "," + COLUMN_OPTION1 + "," + COLUMN_OPTION2 + "," +
                COLUMN_OPTION3 + "," + COLUMN_OPTION4 + "," + COLUMN_CORRECT_ANSWER + ") VALUES ";
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Which artist released the song ''Billie Jean'' in 1983?', 'Michael Jackson', 'Prince', 'Madonna', 'Whitney Houston', 'Michael Jackson');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Who is the lead singer of the band Led Zeppelin?', 'Robert Plant', 'Bono', 'Thom Yorke', 'Dave Grohl', 'Robert Plant');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Which artist released the album ''The Dark Side of the Moon''?', 'Pink Floyd', 'The Beatles', 'The Beach Boys', 'Fleetwood Mac', 'Pink Floyd');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Which female artist had a hit with the song ''Single Ladies (Put a Ring on It)''?', 'Beyoncé', 'Taylor Swift', 'Rihanna', 'Adele', 'Beyoncé');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('What is the name of Elvis Presleys mansion?', 'Graceland', 'Neverland', 'Abbey Road', 'Paisley Park', 'Graceland');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Which artist released the song ''Smells Like Teen Spirit''?', 'Nirvana', 'Guns N Roses', 'Metallica', 'Pearl Jam', 'Nirvana');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Who is the lead singer of the band Muse?', 'Matt Bellamy', 'Chris Martin', 'Bono', 'Thom Yorke', 'Matt Bellamy');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Which artist released the album ''Purple Rain''?', 'Prince', 'Michael Jackson', 'Madonna', 'Whitney Houston', 'Prince');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Who is known as the ''Queen of Pop''?', 'Madonna', 'Britney Spears', 'Taylor Swift', 'Beyoncé', 'Madonna');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Which band is known for the song ''Dont Stop Believin''?', 'Journey', 'AC/DC', 'Bon Jovi', 'Guns N Roses', 'Journey');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Who is the lead singer of the band Red Hot Chili Peppers?', 'Anthony Kiedis', 'Eddie Vedder', 'Dave Grohl', 'Chris Cornell', 'Anthony Kiedis');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Which artist released the album ''Back in Black''?', 'AC/DC', 'Guns N Roses', 'Nirvana', 'Metallica', 'AC/DC');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Who is known as the ''King of Pop''?', 'Michael Jackson', 'Elvis Presley', 'Stevie Wonder', 'James Brown', 'Michael Jackson');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Which female artist had a hit with the song ''Rolling in the Deep''?', 'Adele', 'Lorde', 'Katy Perry', 'Rihanna', 'Adele');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Which band is known for the song ''Under the Bridge''?', 'Red Hot Chili Peppers', 'Nirvana', 'Pearl Jam', 'Foo Fighters', 'Red Hot Chili Peppers');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Who is the lead singer of the band The Who?', 'Roger Daltrey', 'Robert Plant', 'Mick Jagger', 'Freddie Mercury', 'Roger Daltrey');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Which artist released the album ''The Joshua Tree''?', 'U2', 'Coldplay', 'Radiohead', 'Muse', 'U2');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Which artist released the song ''Viva la Vida'' in 2008?', 'Coldplay', 'Radiohead', 'Muse', 'Arctic Monkeys', 'Coldplay');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Which band is known for the song ''Smoke on the Water''?', 'Deep Purple', 'Black Sabbath', 'Led Zeppelin', 'Queen', 'Deep Purple');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Who is the lead singer of the band Bon Jovi?', 'Jon Bon Jovi', 'Bruce Springsteen', 'Elvis Presley', 'Bono', 'Jon Bon Jovi');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Which artist released the album ''Appetite for Destruction''?', 'Guns N Roses', 'Nirvana', 'Metallica', 'AC/DC', 'Guns N Roses');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Who is known as the ''Queen of Soul''?', 'Aretha Franklin', 'Tina Turner', 'Whitney Houston', 'Diana Ross', 'Aretha Franklin');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Which band is known for the song ''Paranoid''?', 'Black Sabbath', 'Deep Purple', 'Led Zeppelin', 'Queen', 'Black Sabbath');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Who is the lead singer of the band Pearl Jam?', 'Eddie Vedder', 'Chris Cornell', 'Anthony Kiedis', 'Dave Grohl', 'Eddie Vedder');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Which artist released the album ''Rumours''?', 'Fleetwood Mac', 'The Eagles', 'The Beach Boys', 'The Rolling Stones', 'Fleetwood Mac');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Which artist released the song Sweet Child o Mine in 1987?', 'Guns N Roses', 'Nirvana', 'Metallica', 'AC/DC', 'Guns N Roses');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Which band is known for the song ''Satisfaction''?', 'The Rolling Stones', 'The Beatles', 'Led Zeppelin', 'Queen', 'The Rolling Stones');");
        db.execSQL(INSERT_MUSIC_MEDIUM_QUESTIONS + "('Who is the lead singer of the band Green Day?', 'Billie Joe Armstrong', 'Eddie Vedder', 'Chris Cornell', 'Kurt Cobain', 'Billie Joe Armstrong');");


        String CREATE_MUSIC_HARD_QUESTIONS_TABLE = "CREATE TABLE " + TABLE_MUSIC_HARD_QUESTIONS +
                "(" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_QUESTION + " TEXT," +
                COLUMN_OPTION1 + " TEXT," +
                COLUMN_OPTION2 + " TEXT," +
                COLUMN_OPTION3 + " TEXT," +
                COLUMN_OPTION4 + " TEXT," +
                COLUMN_CORRECT_ANSWER + " TEXT" +
                ")";
        db.execSQL(CREATE_MUSIC_HARD_QUESTIONS_TABLE);

        String INSERT_MUSIC_HARD_QUESTIONS = "INSERT INTO " + TABLE_MUSIC_HARD_QUESTIONS +
                "(" + COLUMN_QUESTION + "," + COLUMN_OPTION1 + "," + COLUMN_OPTION2 + "," +
                COLUMN_OPTION3 + "," + COLUMN_OPTION4 + "," + COLUMN_CORRECT_ANSWER + ") VALUES ";
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Which artist released the album ''Abbey Road''?', 'The Beatles', 'Pink Floyd', 'Led Zeppelin', 'The Beach Boys', 'The Beatles');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Who is the lead singer of the band Aerosmith?', 'Steven Tyler', 'Bon Jovi', 'Bruce Springsteen', 'Bono', 'Steven Tyler');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Which artist released the song ''Imagine'' in 1971?', 'John Lennon', 'Paul McCartney', 'George Harrison', 'Ringo Starr', 'John Lennon');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Who is known as the ''Queen of Country Music''?', 'Dolly Parton', 'Shania Twain', 'Patsy Cline', 'Reba McEntire', 'Dolly Parton');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Which band is known for the song ''Stairway to Heaven''?', 'Led Zeppelin', 'The Beatles', 'Pink Floyd', 'The Rolling Stones', 'Led Zeppelin');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Who is the lead singer of the band Black Sabbath?', 'Ozzy Osbourne', 'Robert Plant', 'Mick Jagger', 'Freddie Mercury', 'Ozzy Osbourne');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Which artist released the album ''Born to Run''?', 'Bruce Springsteen', 'Elvis Presley', 'Bob Dylan', 'David Bowie', 'Bruce Springsteen');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Which artist released the song ''Bohemian Rhapsody'' in 1975?', 'Queen', 'Led Zeppelin', 'The Beatles', 'The Rolling Stones', 'Queen');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Who is known as the ''Godfather of Soul''?', 'James Brown', 'Stevie Wonder', 'Michael Jackson', 'Prince', 'James Brown');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Which band is known for the song ''Highway to Hell''?', 'AC/DC', 'Guns N Roses', 'Metallica', 'Nirvana', 'AC/DC');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Who is the lead singer of the band Pink Floyd?', 'Roger Waters', 'David Gilmour', 'Syd Barrett', 'Robert Plant', 'Roger Waters');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Which artist released the album ''Graceland''?', 'Paul Simon', 'Bob Dylan', 'Johnny Cash', 'Elvis Presley', 'Paul Simon');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Who is known as the ''King of Reggae''?', 'Bob Marley', 'Peter Tosh', 'Bunny Wailer', 'Jimmy Cliff', 'Bob Marley');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Which band is known for the song ''Imagine''?', 'The Beatles', 'Led Zeppelin', 'Pink Floyd', 'The Rolling Stones', 'The Beatles');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Who is the lead singer of the band Queen?', 'Freddie Mercury', 'Robert Plant', 'Mick Jagger', 'Roger Daltrey', 'Freddie Mercury');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Which artist released the album ''Pet Sounds''?', 'The Beach Boys', 'The Beatles', 'The Rolling Stones', 'Fleetwood Mac', 'The Beach Boys');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Which artist released the song ''Hey Jude'' in 1968?', 'The Beatles', 'Led Zeppelin', 'Queen', 'The Rolling Stones', 'The Beatles');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Who is known as the ''Piano Man''?', 'Billy Joel', 'Elton John', 'Jerry Lee Lewis', 'Ray Charles', 'Billy Joel');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Which band is known for the song ''Comfortably Numb''?', 'Pink Floyd', 'Led Zeppelin', 'The Beatles', 'The Rolling Stones', 'Pink Floyd');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Who is the lead singer of the band The Who?', 'Roger Daltrey', 'Robert Plant', 'Mick Jagger', 'Freddie Mercury', 'Roger Daltrey');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Which artist released the album ''Exile on Main St.''?', 'The Rolling Stones', 'The Beatles', 'Led Zeppelin', 'Pink Floyd', 'The Rolling Stones');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Who is known as the ''Rocket Man''?', 'Elton John', 'Billy Joel', 'David Bowie', 'Stevie Wonder', 'Elton John');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Which band is known for the song ''Hotel California''?', 'The Eagles', 'Fleetwood Mac', 'The Beach Boys', 'Led Zeppelin', 'The Eagles');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Who is the lead singer of the band The Doors?', 'Jim Morrison', 'Roger Waters', 'David Gilmour', 'Syd Barrett', 'Jim Morrison');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Which artist released the album ''Nevermind''?', 'Nirvana', 'Guns N Roses', 'Metallica', 'Pearl Jam', 'Nirvana');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Who is known as the ''Prince of Pop''?', 'Justin Timberlake', 'Bruno Mars', 'The Weeknd', 'Shawn Mendes', 'Justin Timberlake');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Which band is known for the song ''Wish You Were Here''?', 'Pink Floyd', 'Led Zeppelin', 'The Beatles', 'The Rolling Stones', 'Pink Floyd');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Who is the lead singer of the band The Police?', 'Sting', 'Bono', 'Thom Yorke', 'Freddie Mercury', 'Sting');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Which artist released the album ''Thriller''?', 'Michael Jackson', 'Prince', 'Madonna', 'Whitney Houston', 'Michael Jackson');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Who is known as the ''Material Girl''?', 'Madonna', 'Britney Spears', 'Taylor Swift', 'Beyoncé', 'Madonna');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Which band is known for the song ''Sultans of Swing''?', 'Dire Straits', 'Eagles', 'Fleetwood Mac', 'Queen', 'Dire Straits');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Who is the lead singer of the band Van Halen?', 'David Lee Roth', 'Steven Tyler', 'Bon Jovi', 'Bruce Springsteen', 'David Lee Roth');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Which artist released the album ''London Calling''?', 'The Clash', 'The Sex Pistols', 'The Ramones', 'The Cure', 'The Clash');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Which artist released the song ''Livin on a Prayer''?', 'Bon Jovi', 'Guns N Roses', 'Nirvana', 'Metallica', 'Bon Jovi');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Who is known as the ''King of Rock and Roll''?', 'Elvis Presley', 'Michael Jackson', 'Stevie Wonder', 'James Brown', 'Elvis Presley');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Which band is known for the song ''Sweet Home Alabama''?', 'Lynyrd Skynyrd', 'AC/DC', 'Guns N Roses', 'Nirvana', 'Lynyrd Skynyrd');");
        db.execSQL(INSERT_MUSIC_HARD_QUESTIONS + "('Who is the lead guitarist of the band Polyphia?', 'Tim Henson', 'Scott LePage', 'Jason Richardson', 'Ichika Nito', 'Tim Henson');");
    }



    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPUTER_EASY_QUESTIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPUTER_MEDIUM_QUESTIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_COMPUTER_HARD_QUESTIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRIVIA_EASY_QUESTIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRIVIA_MEDIUM_QUESTIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_TRIVIA_HARD_QUESTIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MUSIC_EASY_QUESTIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MUSIC_MEDIUM_QUESTIONS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_MUSIC_HARD_QUESTIONS);
        onCreate(db);
    }

    public List<Question> getAllComputerEasyQuestions() {
        return getQuestions(TABLE_COMPUTER_EASY_QUESTIONS);
    }

    public List<Question> getAllComputerMediumQuestions() {
        return getQuestions(TABLE_COMPUTER_MEDIUM_QUESTIONS);
    }

    public List<Question> getAllComputerHardQuestions() {
        return getQuestions(TABLE_COMPUTER_HARD_QUESTIONS);
    }

    public List<Question> getAllTriviaEasyQuestions() {
        return getQuestions(TABLE_TRIVIA_EASY_QUESTIONS);
    }

    public List<Question> getAllTriviaMediumQuestions() {
        return getQuestions(TABLE_TRIVIA_MEDIUM_QUESTIONS);
    }

    public List<Question> getAllTriviaHardQuestions() {
        return getQuestions(TABLE_TRIVIA_HARD_QUESTIONS);
    }

    public List<Question> getAllMusicEasyQuestions() {
        return getQuestions(TABLE_MUSIC_EASY_QUESTIONS);
    }

    public List<Question> getAllMusicMediumQuestions() {
        return getQuestions(TABLE_MUSIC_MEDIUM_QUESTIONS);
    }

    public List<Question> getAllMusicHardQuestions() {
        return getQuestions(TABLE_MUSIC_HARD_QUESTIONS);
    }
    private List<Question> getQuestions(String tableName) {
        List<Question> questionList = new ArrayList<>();
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM " + tableName, null);
        if (cursor.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                question.setQuestion(cursor.getString(cursor.getColumnIndex(COLUMN_QUESTION)));
                question.setOption1(cursor.getString(cursor.getColumnIndex(COLUMN_OPTION1)));
                question.setOption2(cursor.getString(cursor.getColumnIndex(COLUMN_OPTION2)));
                question.setOption3(cursor.getString(cursor.getColumnIndex(COLUMN_OPTION3)));
                question.setOption4(cursor.getString(cursor.getColumnIndex(COLUMN_OPTION4)));
                question.setCorrectAnswer(cursor.getString(cursor.getColumnIndex(COLUMN_CORRECT_ANSWER)));
                questionList.add(question);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return questionList;
    }
    public String displayQuestions(String tableName) {
        StringBuilder result = new StringBuilder();
        List<Question> questions = getQuestions(tableName);

        // Iterate through the list of questions and append their details to the result
        for (Question question : questions) {
            result.append("Question ID: ").append(question.getId()).append("\n");
            result.append("Question: ").append(question.getQuestion()).append("\n");
            result.append("Option 1: ").append(question.getOption1()).append("\n");
            result.append("Option 2: ").append(question.getOption2()).append("\n");
            result.append("Option 3: ").append(question.getOption3()).append("\n");
            result.append("Option 4: ").append(question.getOption4()).append("\n");
            result.append("Correct Answer: ").append(question.getCorrectAnswer()).append("\n");
            result.append("--------------------").append("\n");
        }

        return result.toString();
    }


    public void updateQuestion(String tableName, int questionId, String newQuestion, String newOption1, String newOption2, String newOption3, String newOption4, String newCorrectAnswer) {
            SQLiteDatabase db = getWritableDatabase();
            ContentValues values = new ContentValues();
            values.put(COLUMN_QUESTION, newQuestion);
            values.put(COLUMN_OPTION1, newOption1);
            values.put(COLUMN_OPTION2, newOption2);
            values.put(COLUMN_OPTION3, newOption3);
            values.put(COLUMN_OPTION4, newOption4);
            values.put(COLUMN_CORRECT_ANSWER, newCorrectAnswer);
            db.update(tableName, values, COLUMN_ID + " = ?", new String[]{String.valueOf(questionId)});
        }

    public void insertQuestion(String tableName, String question, String option1, String option2, String option3, String option4, String correctAnswer) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_QUESTION, question);
        values.put(COLUMN_OPTION1, option1);
        values.put(COLUMN_OPTION2, option2);
        values.put(COLUMN_OPTION3, option3);
        values.put(COLUMN_OPTION4, option4);
        values.put(COLUMN_CORRECT_ANSWER, correctAnswer);
        db.insert(tableName, null, values);
    }

    public boolean isQuestionInserted(String tableName, String question) {
        SQLiteDatabase db = getReadableDatabase();

        String[] columns = {COLUMN_QUESTION};
        String selection = COLUMN_QUESTION + " = ?";
        String[] selectionArgs = {question};

        Cursor cursor = db.query(tableName, columns, selection, selectionArgs, null, null, null);
        boolean isInserted = cursor.moveToFirst();
        cursor.close();

        return isInserted;
    }

    public void deleteQuestion(String tableName, int questionId) {
        SQLiteDatabase db = getWritableDatabase();
        db.delete(tableName, COLUMN_ID + " = ?", new String[]{String.valueOf(questionId)});
    }

    public boolean isQuestionExists(String tableName, int questionId) {
        SQLiteDatabase db = getReadableDatabase();
        String selection = COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(questionId)};
        Cursor cursor = db.query(tableName, null, selection, selectionArgs, null, null, null);
        boolean isExists = cursor.moveToFirst();
        cursor.close();
        return isExists;
    }

    public Question selectQuestion(String tableName, int questionId) {
        SQLiteDatabase db = getReadableDatabase();
        String selection = COLUMN_ID + " = ?";
        String[] selectionArgs = {String.valueOf(questionId)};
        Cursor cursor = db.query(tableName, null, selection, selectionArgs, null, null, null);

        Question question = null;
        if (cursor.moveToFirst()) {
            String questionText = cursor.getString(cursor.getColumnIndex(COLUMN_QUESTION));
            String option1 = cursor.getString(cursor.getColumnIndex(COLUMN_OPTION1));
            String option2 = cursor.getString(cursor.getColumnIndex(COLUMN_OPTION2));
            String option3 = cursor.getString(cursor.getColumnIndex(COLUMN_OPTION3));
            String option4 = cursor.getString(cursor.getColumnIndex(COLUMN_OPTION4));
            String correctAnswer = cursor.getString(cursor.getColumnIndex(COLUMN_CORRECT_ANSWER));

            question = new Question(questionId, questionText, option1, option2, option3, option4, correctAnswer);
        }

        cursor.close();
        return question;
    }

}


