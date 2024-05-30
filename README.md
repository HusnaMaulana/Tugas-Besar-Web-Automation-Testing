# Automation-Web-Testing
Projek automation testing api untuk menguji management user pada tautan https://dummyapi.io/. Proyek ini dikembangkan menggunakan bahasa java (pembuatan script test) dan Gradle (build management)

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
```    

# Struture Project Test
Tujuan project adalah proses pengujian automation web dan api, sehingga kode program tersimpan dalam package test. Adapun struktur package sbb:
```
API-Testing/
├── .gradle/
├── .vscode/
├── app/
│   ├── build/
│   │   ├── classes/
│   │   │   ├── java/
│   │   │   │   ├── main/
│   │   │   │   │   └── test/
│   │   │   │   │       └── api/
│   │   │   │   │           └── App.class
│   │   │   │   └── test/
│   │   │   │       └── test/
│   │   │   │           └── api/
│   │   │   │               ├── UserApiTestDelete.class
│   │   │   │               ├── UserApiTestGet.class
│   │   │   │               ├── UserApiTestPost.class
│   │   │   │               └── UserApiTestPut.class
│   │   ├── generated/
│   │   │   └── sources/
│   │   │       ├── annotationProcessor/
│   │   │       │   └── java/
│   │   │       │       ├── main/
│   │   │       │       └── test/
│   │   │       ├── headers/
│   │   │       │   └── java/
│   │   │       │       ├── main/
│   │   │       │       └── test/
│   │   │       ├── main/
│   │   │       └── test/
│   │   ├── resources/
│   │   └── tmp/
│   │       ├── compileJava/
│   │       │   └── previous-compilation-data.bin
│   │       └── compileTestJava/
│   │           └── previous-compilation-data.bin
│   ├── src/
│   │  ├──── main/
│   │  │   └── java/
│   │  │       └── test/
│   │  │           └── api/
│   │  │               └── App.java
│   │  └── test/
│   │      └── java/
│   │          └── test/
│   │              └── api/
│   │                  ├── UserApiTestDelete.java
│   │                  ├── UserApiTestGet.java
│   │                  ├── UserApiTestPost.java
│   │                  └── UserApiTestPut.java
│   ├── build.gradle
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── .gitattributes
├── .gitignore
├── gradlew
├── gradlew.bat
├── README.md
└── settings.gradle

    
```


 `.gradle/`: Direktori ini berisi file-file cache dan metadata yang digunakan oleh Gradle selama proses build.
`.vscode/`: Direktori ini berisi konfigurasi spesifik untuk lingkungan pengembangan Visual Studio Code (VSCode).
`app/`:
   - `build/`:
     - `classes/java/`: Direktori ini berisi file-file kelas Java yang telah dikompilasi, baik untuk kode sumber utama (`main/`) maupun kode pengujian (`test/`).
     - `generated/sources/`: Direktori ini berisi kode sumber yang dihasilkan secara otomatis selama proses build, seperti file-file yang dihasilkan oleh prosesor anotasi (`annotationProcessor/`) dan header (`headers/`).
     - `resources/`: Direktori ini berisi file-file sumber daya (resources) yang digunakan oleh aplikasi.
     - `tmp/`: Direktori ini berisi file-file sementara yang digunakan selama proses kompilasi (`compileJava/` dan `compileTestJava/`).
   - `src/`:
     - `main/java/test/api/`: Direktori ini berisi kode sumber utama dari aplikasi, terutama kelas `App.java`.
     - `test/java/test/api/`: Direktori ini berisi kode sumber untuk pengujian aplikasi, seperti kelas-kelas `UserApiTestDelete.java`, `UserApiTestGet.java`, `UserApiTestPost.java`, dan `UserApiTestPut.java`.
   - `build.gradle`: File konfigurasi Gradle untuk aplikasi, yang berisi informasi tentang dependensi, tugas-tugas build, dan pengaturan lainnya.


 `gradle/wrapper/`:
   - `gradle-wrapper.jar`: File JAR yang digunakan untuk menjalankan Gradle Wrapper, yang memungkinkan distribusi dan eksekusi Gradle tanpa menginstal Gradle secara lokal.
   - `gradle-wrapper.properties`: File konfigurasi untuk Gradle Wrapper.


`.gitattributes`: File konfigurasi untuk Git yang menentukan cara Git mengelola berbagai jenis file dalam repositori.


`.gitignore`: File yang berisi daftar pola-pola file dan direktori yang akan diabaikan oleh Git, misalnya file-file hasil build atau file-file konfigurasi lokal.


`gradlew` dan `gradlew.bat`: Skrip untuk menjalankan Gradle dari baris perintah di lingkungan Unix/Linux dan Windows, secara berturut-turut.


`README.md`: File Markdown yang biasanya berisi informasi penting tentang proyek, seperti deskripsi, instruksi instalasi, dan dokumentasi.


`settings.gradle`: File konfigurasi Gradle yang berisi informasi tentang modul-modul yang ada dalam proyek.


Note.
1. Setiap kali menjalankan automation testing, akan terbentuk hasil test report yang dapat diakses pada folder test-api\app\build\reports\tests\test\index.html

# Workflow
Langkah-Langkah Membuat Skrip Tes 
Buat direktori tes.
Pastikan Anda memiliki direktori yang sesuai untuk menyimpan file pengujian. Struktur folder yang ditentukan menyediakan direktori untuk pengujian di bawah app/src/test/java.
Membuat kelas uji.
Buat kelas tes di direktori tes untuk menguji kelas utama. Pada testing yang kami uji, kami membuat UserApiTestGet.java untuk menguji fungsionalitas pengambilan data API, UserApiTestPut.java untuk menguji fungsionalitas pembaruan data API, UserApiTestPost.java unntuk menguji fungsionalitas penambahan data API, dan UserApiTestDelete.java untuk menguji fungsionalitas penghapusan data  API.
Gunakan kerangka pengujian.
Kelas pengujian yang Anda buat menggunakan kerangka pengujian seperti JUnit. Anda dapat menambahkan anotasi JUnit seperti @Test ke metode yang ingin Anda uji. salah satu contohnya yaitu :  
@Test
    public void testCase1_03() {
	. . .
}


Menulis kasus uji.
Tulis kode dalam metode yang dianotasi sebagai @Test untuk menguji fungsionalitas  kelas atau metode yang diinginkan. Anda dapat menggunakan berbagai metode penegasan JUnit, seperti penegasanEquals dan penegasanTrue, untuk memastikan bahwa kelas atau metode berperilaku seperti yang Anda harapkan.
Jalankan kasus uji.
Setelah membuat kasus uji, Anda dapat menjalankannya  menggunakan perintah build Gradle (./gradlew build/gradle build). Anda biasanya dapat menjalankan kasus pengujian dengan menjalankan perintah ./gradlew test/gradle test dari terminal di dalam direktori proyek Anda. perintah tersebut akan menjalankan semua kasus uji yang ditemukan dalam proyek  dan melaporkan hasilnya.
 






# How to Run Execution Testing
Proses menjalankan eksekusi testing terdiri dari dua cara, yaitu Terminal dan Class testRunner

## Terminal
Proses menjalankan eksekusi testing melalui terminal dengan menjalankan kode berikut:
```
./gradlew test
```
Namun, sebelumnya harus dilakukan build terlebih dahulu agar library dependency sudah terkonfigurasi pada project. Kode build sbb:
```
./gradlew build
```
## Class TestRunner
Cukup dengan melakukan running test menggunakan icon run IDE pada Class TestRunner 

## Persiapan Data
Sebelum menjalankan test case, diperlukan persiapan data test: 
1. Pastikan App-id yang digunakan valid 
2. Pastikan id user valid saat menguji update user, delete user
3. Ubah parameter id user untuk update dan delete 

# Software Under test
pengujian API dilakukan dengan menggunakan api management user yang diakses pada tautan Dummy API - User Data Controllers
* hit api get profile user by id
* hit api post new user
* hit api update user by id
* hit api delete user by id

# Test Case
Pembuatan test case meliputi test positif dan test negatif, yaitu
## Test Case API User Method Post
Operasi tidak punya authorization
field lain terisi, dan field first name di isi huruf dengan panjang antara 2-50
field lain terisi, dan field last name di isi huruf dengan panjang antara 2-50
field lain terisi, dan field title di isi dengan mr
field lain terisi, dan field title di isi dengan ms
field lain terisi, dan field title di isi dengan mrs
field lain terisi, dan field title di isi dengan miss
field lain terisi, dan field title di isi dengan dr
field lain terisi, dan field gander di isi dengan male
field lain terisi, dan field gander di isi dengan female
field lain terisi, dan field email di isi email yang belum terdaftar 
field lain terisi, dan field DateOfBirtth di isi dengan data yang valid
field lain terisi, dan field Phone di isi dengan format +62 
field lain terisi, dan field Phone di isi dengan format 08
field lain terisi, dan field picture di isi data URL valid
field lain terisi, dan field location di isi dengan data valid
user laki-laki, email sudah terdaftar
user perempuan, email sudah terdaftar
field lain terisi, kecuali titlel diisi kosong
field lain terisi, kecuali first name kosong
field lain terisi, kecuali last name kosong
field lain terisi, kecuali gender diisi kosong
field lain terisi, kecuali email diisi kosong
field lain terisi, kecuali dateOfBirth diisi kosong
field lain terisi, kecuali phone diisi kosong
field lain terisi, kecuali picture diisi kosong
field lain terisi, kecuali location diisi kosong
semua field diisi kosong
field lain benar, format first name invalid (first name diisi lebih dari 50 karakter atau dibawah 2 karakter)
field lain benar, format first name invalid (first name diisi angka atau simbol )
field lain benar, format last name invalid (last name diisi lebih dari 50 karakter atau dibawah 2 karakter)
field lain benar, format last name nvalid (first name diisi angka atau simbol )
field lain benar, format email invalid (menggunakan @, tetapi nama sudah terdaftar)
field lain benar, format email invalid (tanpa menggunakan @)
field lain benar, format phone invalid (menggunakan huruf)
field lain benar, format tanggal tidak benar (29/02/2003)
field lain benar namun data gender invalid, yaitu selain "male" dan "female"
field lain benar namun data title invalid, yaitu selain "mr", "ms", "mrs", "miss", "dr"
field lain benar namun data URL tidak valid
field lain benar namun data location tidak valid

## Test Case API User Method Get
Operasi tidak punya authorization
app-id valid, dan user id ada pada sistem
app-id valid, dan user id tidak ada pada sistem
app-id valid, dan user id tidak sesuai format
api-id tidak valid, dan user id ada pada sistem

## Test Case API User Method Put
Pemeriksaan update user tanpa mengatur app-id pada header request
Mengubah beberapa field data user dengan input data yang valid dan id yang terdaftar
Mengubah semua field data user dengan input data yang valid dan id yang terdaftar
Mengubah field "firstName" pada data user dengan input data yang valid dan id yang terdaftar
Mengubah field "lastName" pada data user dengan input data yang valid dan id yang terdaftar
Mengubah isi field "title" dengan "mr"  pada data user dengan input data yang valid dan id yang terdaftar
Mengubah isi field "title" dengan "ms"  pada data user dengan input data yang valid dan id yang terdaftar
Mengubah isi field "title" dengan "mrs"  pada data user dengan input data yang valid dan id yang terdaftar
Mengubah isi field "title" dengan "miss"  pada data user dengan input data yang valid dan id yang terdaftar
Mengubah isi field "title" dengan "dr"  pada data user dengan input data yang valid dan id yang terdaftar
Mengubah isi field "title" dengan ""  pada data user dengan input data yang valid dan id yang terdaftar
Mengubah isi field "gender" dengan "male"  pada data user dengan input data yang valid dan id yang terdaftar
Mengubah isi field "gender" dengan "female"  pada data user dengan input data yang valid dan id yang terdaftar
Mengubah isi field "gender" dengan "other"  pada data user dengan input data yang valid dan id yang terdaftar
Mengubah isi field "gender" dengan ""  pada data user dengan input data yang valid dan id yang terdaftar
Mengubah isi field "email" dengan format email yang valid dan id yang terdaftar
Mengubah isi field "dateOfBirth" dengan format yang valid dan id yang terdaftar
Mengubah isi field "phone" dengan format yang valid dan id yang terdaftar
Mengubah isi field "picture" dengan format yang valid dan id yang terdaftar
melakukan update user dengan mengubah object location  pada sub field street diisi dengan input karakter dalam range yang valid, dengan id yang valid dan terdaftar.
melakukan update user dengan mengubah object location  pada sub field city diisi dengan input karakter dalam range yang valid, dengan id yang valid dan terdaftar.
melakukan update user dengan mengubah object location  pada sub field state diisi dengan input karakter dalam range yang valid, dengan id yang valid dan terdaftar.
melakukan update user dengan mengubah object location  pada sub field country diisi dengan input karakter dalam range yang valid, dengan id yang valid dan terdaftar.
Mengubah field "firstName" pada data user dengan input data bertipe integer dan id yang terdaftar
Mengubah field "lastName" pada data user dengan input data bertipe integer dan id yang terdaftar
Mengubah Field "title" diisi dr dengan tanpa tanda ""
Mengubah Field "gender" diisi male dengan tanpa tanda ""
Mengubah isi field "email" dengan format email yang invalid dan id yang terdaftar
Mengubah Field "dateOfBirthday" dengan format invalid (tidak mengikuti format dd/mm/yyyy)
Mengubah Field "picture" diisi dengan tanpa menggunakan ""
Mengubah Field "street" pada objek "location" diisi dengan tipe data integer
Mengubah Field "city" pada objek "location" diisi dengan tipe data integer
Mengubah Field "state" pada objek "location" diisi dengan tipe data integer
Mengubah Field "country" pada objek "location" diisi dengan tipe data integer
Mengubah isi Field "firstName" dengan input diluar range karakter yang valid
Mengubah isi Field "lastName" dengan input diluar range karakter yang valid
Field "title" diisi string selain ("mr", "ms", "mrs", "miss", "dr", "")
Field "gender" diisi string selain ("male", "female", "other", "")
Field "dateOfBirth" diisi tanggal pada tahun sebelum 1900
Field "dateOfBirth" diisi tanggal setelah hari ini
Field "street" pada objek "location" diisi dengan input diluar range karakter yang valid
Field "city" pada objek "location" diisi dengan input diluar range karakter yang valid
Field "state" pada objek "location" diisi dengan input diluar range karakter yang valid
Field "country" pada objek "location" diisi dengan input diluar range karakter yang valid
semua field diisi benar, parameter tidak terdaftar

## Test Case API User Method Delete
Operasi tidak punya authorization
app-id valid, dan user id ada pada sistem
app-id valid, dan user id tidak ada pada sistem
app-id valid, dan user id tidak sesuai format
api-id tidak valid, dan user id ada pada sistem



