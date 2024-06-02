# Automation-Web-Testing
Projek automation web testing untuk menguji fitur login dan logout pada tautan https://www.saucedemo.com/. Proyek ini dikembangkan menggunakan bahasa java (pembuatan script test) dan maven (build management)

# Build With
Proyek pengujian otomatis melibatkan tiga buah library yang dibutuhkan.
- Junit
- Cucumber
- Selenium

# Getting Started

## Prerequisite
Sebelum menjalankan proyek ini, diperlukan persyaratan environment yang harus disiapkan pada device eksekusi proyek
1. JDK diatas versi 8
2. Maven

## Installation
Proses instalasi proyek ini pada local environment
1. Download source code git hub
2. Buka IDE pemrograman. Misalnya VsCode
3. Buat proyek baru dengan mode import source code existing
4. Lakukan pengaturan project bagian Java dan Maven dengan
   - Arahkan path Java ke lokasi instalasi JDK

## File Configuration
Proses konfigurasi project menggunakan build automation pada File build.gradle. 
1. Semua dependency yang dibutuhkan harus ditambahkan di dalam dependencies. Penambahan kode dependency cukup menambahkan tag xml file pada pom.xml. Berikut dependency yang dibutuhkan:
   a. Junit, library untuk melakukan testing dengan menggunakan bahasa java
   ```
       <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit</artifactId>
            <version>7.0.0</version> <!-- Versi terbaru -->
            <scope>test</scope>
        </dependency>
   ```
   b. Selenium, sebagai web driver 
   ```
       <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
            <version>4.8.2</version> <!-- Versi terbaru -->
            <scope>test</scope>
        </dependency>
   ```
   c. Cucumber, library untuk melakukan automation web testing
   ```
       <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>7.0.0</version> <!-- Versi terbaru -->
            <scope>test</scope>
        </dependency>
   ``` 

# Struture Project Test
Tujuan project adalah proses pengujian automation web, sehingga kode program tersimpan dalam package test. Adapun struktur package sbb:

```
Automation-Web-Testing/
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── automation
│   │               └── Main.java
│   ├── test
│   │   ├── java
│   │   │   └── com
│   │   │       └── automation
│   │   │           ├── hooks
│   │   │           │   └── Hooks.java
│   │   │           ├── pages
│   │   │           │   ├── LoginPage.java
│   │   │           │   └── ProductsPage.java
│   │   │           ├── stepdefinitions
│   │   │           │   └── LoginSteps.java
│   │   │           └── RunCucumberTest.java
│   │   └── resources
│   │       ├── loginemptyfield.feature
│   │       ├── loginemptypassword.feature
│   │       ├── loginemptyusername.feature
│   │       ├── logininvalidpassword.feature
│   │       ├── loginInvalidUsername.feature
│   │       ├── loginInvalidUsernamepassword.feature
│   │       ├── loginvalid.feature
│   │       ├── logout.feature
│   │       └── showloginpage.feature
├── target
│   ├── classes
│   │   └── com
│   │       └── automation
│   │           └── Main.class
│   ├── maven-status
│   │   └── maven-compiler-plugin
│   │       ├── compile
│   │       └── testCompile
│   ├── surefire-reports
│   │   ├── 2024-05-17T22-32-40_041.dumpstream
│   │   ├── 2024-05-18T21-06-59_542.dumpstream
│   │   ├── com.automation.RunCucumberTest.txt
│   │   └── TEST-com.automation.RunCucumberTest.xml
│   ├── test-classes
│   │   └── com
│   │       ├── loginemptyfield.feature
│   │       ├── loginemptypassword.feature
│   │       ├── loginemptyusername.feature
│   │       ├── logininvalidpassword.feature
│   │       ├── loginInvalidUsername.feature
│   │       ├── loginInvalidUsernamepassword.feature
│   │       ├── loginvalid.feature
│   │       ├── logout.feature
│   │       └── showloginpage.feature
│   └── cucumber.html
├── msedgedriver.exe
├── pom.xml
└── README.md
```



1.	src/main/java/com/automation/Main.java: Berkas utama yang menjalankan aplikasi Java.
2.	src/test/java/com/automation/hooks/Hooks.java: Berkas yang mengandung hook untuk tes Cucumber.
3.	src/test/java/com/automation/pages:
   	- LoginPage.java: Kelas yang merepresentasikan halaman login.
  	- ProductsPage.java: Kelas yang merepresentasikan halaman produk.
5.	src/test/java/com/automation/stepdefinitions/LoginSteps.java: Berkas yang mengandung definisi langkah-langkah untuk skenario Cucumber terkait login.
6.	src/test/java/com/automation/RunCucumberTest.java: Berkas yang menjalankan tes Cucumber.
7.	src/test/resources: Direktori yang mengandung berkas-berkas fitur Cucumber.
   	- loginemptyfield.feature: Skenario pengujian untuk login dengan field kosong.
  	- loginemptypassword.feature: Skenario pengujian untuk login dengan password kosong.
  	- loginemptyusername.feature: Skenario pengujian untuk login dengan username kosong.
  	- logininvalidpassword.feature: Skenario pengujian untuk login dengan password tidak valid.
  	- loginInvalidUsername.feature: Skenario pengujian untuk login dengan username tidak valid.
  	- loginInvalidUsernamepassword.feature: Skenario pengujian untuk login dengan username dan password tidak valid.
  	- loginvalid.feature: Skenario pengujian untuk login dengan kredensial yang valid.
  	- logout.feature: Skenario pengujian untuk logout.
  	- showloginpage.feature: Skenario pengujian untuk menampilkan halaman login.
9.	target: Direktori keluaran Maven yang berisi hasil kompilasi dan laporan pengujian.
    	- classes: Berkas kelas yang sudah dikompilasi.
  	- maven-status: Informasi status Maven.
  	- surefire-reports: Laporan pengujian Surefire.
  	- test-classes: Berkas kelas hasil kompilasi tes.
  	- cucumber.html: Laporan hasil tes Cucumber dalam format HTML.
11.	msedgedriver.exe: Eksekusi driver untuk Microsoft Edge.
12.	pom.xml: Berkas konfigurasi Maven.
13.	README.md: Berkas dokumentasi proyek.

Note.
1. Setiap kali menjalankan automation testing, akan terbentuk hasil test report yang dapat diakses pada folder Automation-Web-Testing\target\cucumber.html

# Workflow
1. Langkah-Langkah Membuat Skrip Tes 
2. Buat direktori tes.
   - Pastikan Anda memiliki direktori yang sesuai untuk menyimpan file pengujian. Struktur folder yang ditentukan menyediakan direktori untuk pengujian di bawah app/src/test/java.
3. Membuat kelas uji.
   - Buat kelas tes di direktori tes untuk menguji kelas utama. Pada testing yang kami uji, kami membuat UserApiTestGet.java untuk menguji fungsionalitas pengambilan data API, UserApiTestPut.java untuk menguji fungsionalitas pembaruan data API, UserApiTestPost.java unntuk menguji fungsionalitas penambahan data API, dan UserApiTestDelete.java untuk menguji fungsionalitas penghapusan data  API.
4. Gunakan kerangka pengujian.
Kelas pengujian yang Anda buat menggunakan kerangka pengujian seperti JUnit. Anda dapat menambahkan anotasi JUnit seperti @Test ke metode yang ingin Anda uji. salah satu contohnya yaitu :  

```
@Test
    public void testCase1_03() {
	. . .
}
```

Menulis kasus uji.
Tulis kode dalam metode yang dianotasi sebagai @Test untuk menguji fungsionalitas  kelas atau metode yang diinginkan. Anda dapat menggunakan berbagai metode penegasan JUnit, seperti penegasanEquals dan penegasanTrue, untuk memastikan bahwa kelas atau metode berperilaku seperti yang Anda harapkan.
Jalankan kasus uji.
Setelah membuat kasus uji, Anda dapat menjalankannya  menggunakan perintah build Gradle (./gradlew build/gradle build). Anda biasanya dapat menjalankan kasus pengujian dengan menjalankan perintah ./gradlew test/gradle test dari terminal di dalam direktori proyek Anda. perintah tersebut akan menjalankan semua kasus uji yang ditemukan dalam proyek  dan melaporkan hasilnya.
 
# How to Run Execution Testing
Proses menjalankan eksekusi testing terdiri dari dua cara, yaitu Terminal dan RunCucumberTest

## Terminal
Proses menjalankan eksekusi testing melalui terminal dengan menjalankan kode berikut:
```
mvn clean test
```
## Class TestRunner
Cukup dengan melakukan running test menggunakan icon run IDE pada Class RunCucumberTest

# Software Under test
pengujian Web dilakukan pada halaman login terdapat 2 fitur yang akan di cek yaitu :
* fitur login
* fitur logout

# Test Case
Pembuatan test case meliputi test positif dan test negatif, yaitu
## Test Case untuk fitur login
1. Menguji Tampil Halaman Login
2. Menguji Login Berhasil
3. Menguji Field Password Tidak Terisi
4. Menguji Field Password Tidak Sinkron dengan Username
5. Menguji Field dengan Username kosong
6. Menguji Jika field dengan username tidak ada dalam database
7. Menguji jika field dengan username dan password tidak ada dalam database
8. Menguji jika username dan password kosong

## Test Case untuk fitur logout
9. Menguji logout berhasil
