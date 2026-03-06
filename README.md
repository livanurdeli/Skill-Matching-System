# 🌐 SkillMatch - Yetenek Eşleştirme Sistemi

Bu proje, iş arayanların sahip olduğu yetenekler ile iş ilanlarında aranan gereksinimleri analiz ederek, kullanıcıya en uygun işleri bir **uygunluk skoru (%)** ile sunan dinamik bir web uygulamasıdır. **Spring Boot** ekosistemi kullanılarak geliştirilen bu sistem, işe alım süreçlerini otomatize etmeyi hedefler.

🔗 **Canlı Demo (Live Preview)**
*Projenizi yayınladığınızda linki buraya ekleyebilirsiniz.*
▶️ [Siteyi Görüntüle](#)

---

## 🚀 Proje İçeriği

Site içerisinde aşağıdaki temel modüller yer almaktadır:

* **Giriş ve Kayıt Paneli:** Kullanıcıların sisteme dahil olduğu ve sahip oldukları teknik yetenekleri (Java, SQL, Docker vb.) seçtiği alan.
* **Akıllı Ana Sayfa (Dashboard):** Sisteme giriş yapan kullanıcının yetenek setine göre filtrelenmiş ve skorlanmış iş ilanlarının listelendiği merkez.
* **Eşleştirme Algoritması:** İş ilanındaki zorunlu yetenekler ile kullanıcı yeteneklerini karşılaştırıp 2 ondalık basamağa kadar hassas hesaplama yapan servis katmanı.
* **Dinamik Veri Yönetimi:** Uygulama ayağa kalktığında test verilerini (Skill ve JobPosting) otomatik olarak veritabanına işleyen yapı.

---

## 🛠️ Kullanılan Teknolojiler

Bu proje **Fullstack** bir yaklaşımla, modern Java teknolojileri üzerine inşa edilmiştir:

* **Backend:** Java 17+, Spring Boot
* **Veri Yönetimi:** Spring Data JPA (Hibernate), H2 Database (In-Memory)
* **Frontend:** Thymeleaf (Dinamik HTML şablon motoru), CSS3
* **Araçlar:** Lombok, Maven

---

## 📈 Algoritma Mantığı

Sistem, eşleşme skorunu aşağıdaki formüle dayanarak hesaplar:

$$Score = \left( \frac{\text{Kullanıcıda Bulunan Eşleşen Yetenekler}}{\text{İş İlanındaki Toplam Gerekli Yetenekler}} \right) \times 100$$

*Örnek: Bir ilan 4 yetenek istiyorsa ve kullanıcı bunlardan 3'üne sahipse, uygunluk skoru **%75.0** olarak hesaplanır.*

---

## ⚙️ Kurulum (Yerel Çalıştırma)

Projeyi kendi bilgisayarınızda çalıştırmak isterseniz:

1. **Repoyu Klonlayın:**
   ```bash
   git clone [https://github.com/livanurdeli/skillmatch-system.git](https://github.com/livanurdeli/skillmatch-system.git)
