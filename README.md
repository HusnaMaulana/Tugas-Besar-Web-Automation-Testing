# Tugas Besar Web Automation And API
Projek automation web testing untuk menguji keseluruhan fitur tautan https://www.saucedemo.com/ dan juga menguji API untuk user controller pada tautan https://dummyapi.io/docs/user. Proyek ini dikembangkan menggunakan bahasa java (pembuatan script test) dan maven (build management)

# Anggota Kelompok
- Danu Mahesa - 211524037 (username github : Danum05)
- Husna Maulana - 211524045 (username github : HusnaMaulana)
- Rofaul Akrom Hendrawan - 211524061 (username github : rofaulakrom)
- 
# Build With
Proyek pengujian otomatis melibatkan tiga buah library yang dibutuhkan.
- Junit
- Cucumber
- Selenium
- TestNG
- RestAssured

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
      d. Rest Assured, library untuk melakukan API testing
   ```
        <dependency>
            <groupId>io.rest-assured</groupId>
            <artifactId>rest-assured</artifactId>
            <version>4.4.0</version>
        </dependency>

      e. TestNG, library untuk melakukan pengujian dalam bahasa java yang menyediakan lebih banyak fitur  
   ```
        <dependency>
            <groupId>org.testng</groupId>
            <artifactId>testng</artifactId>
            <version>7.4.0</version>
            <scope>test</scope>
        </dependency>
   ``` 

# Struture Project Test
Tujuan project adalah proses pengujian automation web, sehingga kode program tersimpan dalam package test. Adapun struktur package sbb:

```
Tugas-Besar-Web-Automation/
├── .vscode
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── automation
│   │               └── Main.java
│   └── test
│       ├── java
│       │   └── com
│       │       ├── api
│       │       │   └── stepdefinitions
│       │       │       ├── DeleteUserSteps.java
│       │       │       ├── GetUserSteps.java
│       │       │       ├── PostUserSteps.java
│       │       │       └── PutUserSteps.java
│       │       ├── automation
│       │       │   ├── hooks
│       │       │   │   └── Hooks.java
│       │       │   ├── pages
│       │       │   │   ├── CartPage.java
│       │       │   │   ├── CheckoutPage.java
│       │       │   │   ├── DetailProductPage.java
│       │       │   │   ├── LoginPage.java
│       │       │   │   ├── MenuPage.java
│       │       │   │   └── ProductsPage.java
│       │       │   └── stepdefinitions
│       │       │       ├── CartSteps.java
│       │       │       ├── CheckoutSteps.java
│       │       │       ├── DetailProductSteps.java
│       │       │       ├── LoginSteps.java
│       │       │       ├── MenuSteps.java
│       │       │       └── ProductSteps.java
│       │       └── RunCucumberTest.java
│       └── resources
│           ├── api
│           │   ├── DeleteUserApi.feature
│           │   ├── GetUserApi.feature
│           │   ├── PostUserApi.feature
│           │   └── PutUserApi.feature
│           └── automation
│               ├── cart.feature
│               ├── checkout.feature
│               ├── detailproduct.feature
│               ├── end_to_end.feature
│               ├── login.feature
│               ├── logout.feature
│               ├── menu.feature
│               └── product.feature
├── target
│   ├── classes
│   ├── generated-sources
│   ├── generated-test-sources
│   ├── maven-status
│   ├── surefire-reports
│   └── test-classes
├── msedgedriver.exe
├── pom.xml
└── README.md

```
- **.vscode**: Direktori ini berisi pengaturan spesifik editor untuk Visual Studio Code.
- **src/main/java/com/automation**: Direktori ini berisi kode sumber utama proyek.
    - **Main.java**: Berkas utama yang berisi metode `main()` untuk menjalankan aplikasi Java.
- **src/test/java/com/automation**: Direktori ini berisi kode sumber pengujian proyek.
    - **api/stepdefinitions**: Direktori yang berisi definisi langkah-langkah (step definitions) untuk skenario pengujian API.
    - **automation/hooks**: Direktori yang berisi hook (potongan kode yang dijalankan sebelum atau sesudah skenario) untuk tes menggunakan kerangka kerja Cucumber.
    - **automation/pages**: Direktori yang berisi kelas-kelas yang merepresentasikan halaman-halaman dalam aplikasi.
    - **automation/stepdefinitions**: Direktori yang berisi definisi langkah-langkah (step definitions) untuk skenario pengujian yang menggunakan kerangka kerja Cucumber.
- **src/test/resources**: Direktori yang berisi berkas-berkas fitur Cucumber, yang merupakan deskripsi perilaku sistem dalam format yang dapat dibaca oleh Cucumber.
- **target**: Direktori keluaran dari Maven yang berisi hasil kompilasi, laporan pengujian, dan berkas-berkas lainnya.
- **msedgedriver.exe**: Berkas eksekusi driver untuk mengotomatisasi pengujian di Microsoft Edge.
- **pom.xml**: Berkas konfigurasi Maven untuk proyek ini.

Note.
1. Setiap kali menjalankan automation testing, akan terbentuk hasil test report yang dapat diakses pada folder Automation-Web-Testing\target\cucumber.html

# Workflow
1. Persiapan Direktori Tes:
- Buatlah direktori khusus untuk menyimpan skrip tes.
- Tambahkan file .feature pada src\test\resources\api untuk skenario pengujian api menggunakan format Gherkin.
- Tambahkan file .feature pada src\test\resources\automation untuk skenario pengujian web automation menggunakan format Gherkin.

2. Pembuatan Kelas Uji:
- Buat kelas pengujian pada src\test\java\com\automation\stepdefinitions untuk skenario pengujian web automation
- Jika ingin menambahkan interaksi pada website tambahkan file pada src\test\java\com\automation\pages
- Buat kelas pengujian pada src\test\java\com\api\stepdefinitions untuk skenario pengujian api
  
3. Menjalankan file pengujian:
- buka file runner pada src\test\java\com\RunCucumberTest.java untuk menjalankan script pengujian
 
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
pengujian Web yang dilakukan mencakup fitur :
* fitur login
* fitur product
* fitur menu
* fitur detail product
* fitur cart
* fitur checkout
* fitur logout

pengujian API yang dilakukan mencakup fitur :
* fitur get user
* fitur post user
* fitur put user
* fitur delete user

# Test Case Automation Web Testing
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

## Test Case untuk fitur product
1. Menguji menekan tombol twitter
2. Menguji filter sorting product by name
3. Menguji filter sorting product by price low to high
   
## Test Case untuk fitur menu
1. Menguji menekan tombol menu
2. Menguji menekan tombol about pada side bar
3. Menguji menekan tombol all item pada side bar
   
## Test Case untuk fitur detail produk
1. Menguji menekan gambar pada bagian product
2. Menguji menekan nama pada bagian product
3. Menguji masuk ke halaman detail product dan kembali ke halaman product

## Test Case untuk fitur cart
1. Menguji bagian cart dengan tidak membeli item
2. Menguji bagian cart dengan membeli lebih dari satu item
3. Menguji masuk ke halaman cart dan kembali ke halaman product

## Test Case untuk fitur checkout
1. Menguji checkout succes
2. Menguji halaman checkout dengan firstname kosong
3. Menguji halaman checkout dengan lastname kosong
   
## Test Case untuk fitur logout
1. Menguji logout berhasil

# Test Case Automation API
Pembuatan test case meliputi test positif dan test negatif, yaitu
## Test Case untuk Get User
1. Melakukan permintaan GET data Pengguna tanpa proses otentikasi
2. Melakukan permintaan GET Pengguna dengan ID Pengguna yang valid
3. Melakukan permintaan GET Pengguna dengan ID Pengguna yang salah
4. Melakukan permintaan GET Pengguna dengan ID Pengguna yang tidak ditemukan
5. Melakukan permintaan GET data Pengguna dengan App id dan User Id yang tidak valid
   
## Test Case untuk Post User
1. Membuat pengguna baru dengan detail yang valid
2. Membuat pengguna baru hanya dengan bidang firstName
3. Membuat pengguna baru hanya dengan bidang lastName
4. Membuat pengguna baru hanya dengan bidang email
5. Membuat pengguna baru dengan bidang firstName, tetapi email sudah digunakan sebelumnya
   
## Test Case untuk Put User
1. Memperbarui Pengguna dengan Data yang Valid
2. Menambahkan Nama Belakang ke Pengguna
3. Mengubah Judul menjadi 'mr' untuk Pengguna
4. Mengubah Judul menjadi 'ms' untuk Pengguna
5. Mengubah Judul menjadi 'mrs' untuk Pengguna

## Test Case untuk Delete User
1. Menghapus Data Pengguna tanpa Otorisasi
2. Menghapus Pengguna dengan ID Pengguna yang Valid
3. Menghapus Pengguna dengan ID Pengguna yang Salah
4. Menghapus Pengguna dengan ID Pengguna yang Tidak Ditemukan
5. Menghapus Pengguna dengan ID Pengguna dan APP ID yang Tidak Valid
