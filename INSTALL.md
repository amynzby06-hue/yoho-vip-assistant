# 📥 دليل التحميل والتثبيت الكامل

## 🎯 اختر طريقة التحميل المناسبة لك

---

## ⬇️ **الطريقة 1: التحميل المباشر من GitHub (الأسهل)**

### خطوات التحميل:

```
1. اذهب إلى:
   https://github.com/amynzby06-hue/yoho-vip-assistant

2. اضغط الزر الأخضر Code ☝️
   ↓
   Select: Download ZIP

3. سيحمل ملف ZIP كامل المشروع

4. فك الضغط الملف على جهازك
```

### الملفات المهمة بعد فك الضغط:
```
yoho-vip-assistant/
├── app/src/main/java/com/yoho/vip/assistant/
│   ├── MainActivity.kt ⭐
│   ├── FloatingService.kt ⭐
│   └── FrameEditor.kt ⭐
├── app/build.gradle ⭐
└── AndroidManifest.xml ⭐
```

---

## 💻 **الطريقة 2: Clone من Terminal (للمبرمجين)**

### على Windows:
```bash
# افتح Command Prompt أو PowerShell
cd C:\Users\YourName\Documents

git clone https://github.com/amynzby06-hue/yoho-vip-assistant.git

cd yoho-vip-assistant
```

### على Mac/Linux:
```bash
# افتح Terminal
cd ~/Desktop

git clone https://github.com/amynzby06-hue/yoho-vip-assistant.git

cd yoho-vip-assistant
```

---

## 🛠️ **الطريقة 3: فتح في Android Studio (البناء والتشغيل)**

### الخطوة 1️⃣: تحميل Android Studio
```
اذهب إلى: https://developer.android.com/studio
حمّل البرنامج وثبته
```

### الخطوة 2️⃣: فتح المشروع
```
1. افتح Android Studio
2. File → Open
3. اختر مجلد: yoho-vip-assistant
4. اضغط OK
```

### الخطوة 3️⃣: انتظر المزامنة
```
سيظهر تنبيه "Gradle sync..."
اضغط "Sync Now" إذا طُلب منك
انتظر 2-3 دقائق
```

### الخطوة 4️⃣: وصّل هاتفك أو استخدم محاكي
```
USB Cable → وصّل هاتفك بالكمبيوتر

أو

AVD Manager → إنشء هاتف وهمي
```

### الخطوة 5️⃣: شغّل البرنامج
```
اضغط زر Run الأخضر ▶️
أو اضغط: Shift + F10
```

---

## 📱 **الطريقة 4: تحميل APK جاهز (سيأتي قريباً)**

```
سيكون متاح في:
https://github.com/amynzby06-hue/yoho-vip-assistant/releases

APK الملف = التطبيق الجاهز للتثبيت
يمكنك نقله مباشرة إلى هاتفك وتثبيته
```

---

## ✅ **بعد التثبيت: الخطوات الأساسية**

### 1️⃣ فعّل إذن الظهور فوق التطبيقات

**على جميع هواتف Android:**
```
Settings 
  ↓
Apps 
  ↓
Special app access 
  ↓
Display over other apps
  ↓
ابحث عن: "مساعد يوهو VIP"
  ↓
فعّله ✅
```

**على Xiaomi:**
```
Settings
  ↓
Permissions
  ↓
Display over other apps
  ↓
مساعد يوهو VIP ✅
```

### 2️⃣ فعّل أذونات الكاميرا والمعرض

```
Settings
  ↓
Apps
  ↓
مساعد يوهو VIP
  ↓
Permissions
  ↓
✅ Camera
✅ Storage/Photos
✅ Files
```

### 3️⃣ افتح التطبيق

```
ستظهر الشاشة الرئيسية
وزر 👑 عائم في الزاوية اليمنى العلوية
```

---

## 🎮 **كيفية الاستخدام الأول**

```
1️⃣  اضغط الزر الأخضر "🖼️ اختر صورة"

2️⃣  اختر صورة من معرضك أو التقط وا��دة بالكاميرا

3️⃣  أدخل اسمك (اختياري) في حقل النص

4️⃣  اختر الإطار:
    - ✨ إطار ذهبي ملكي
    - 💎 إطار فضي فاخر

5️⃣  اضغط الزر الأحمر "💾 احفظ الصورة"

6️⃣  تم! الصورة محفوظة في معرضك ✅
```

---

## ⚙️ **المتطلبات والإعدادات**

| متطلب | التفاصيل |
|------|---------|
| **نظام التشغيل** | Android 5.0+ (API 21+) |
| **الهاتف** | أي هاتف ذكي (Android) |
| **المساحة** | 50 MB على الأقل |
| **الإنترنت** | اختياري (للرفع المستقبلي) |
| **الكاميرا** | اختيارية (يمكن استخدام المعرض فقط) |

---

## 🔧 **حل المشاكل الشائعة**

### ❌ **الهاتف لا يظهر في Android Studio**

**الحل:**
```
1. تحقق من وصل كابل USB بشكل صحيح
2. جرّب كابل USB آخر
3. فعّل USB Debugging على الهاتف:
   Settings → Developer Options → USB Debugging ✅
4. اضغط Allow على الهاتف عند الربط
```

### ❌ **"Gradle sync failed"**

**الحل:**
```
1. File → Sync Now
2. إذا لم ينجح:
   File → Invalidate Caches / Restart
3. انتظر 5 دقائق
```

### ❌ **الزر العائم لا يظهر**

**الحل:**
```
فعّل "Display over other apps" من Settings
(شرح كامل أعلى ☝️)
```

### ❌ **خطأ في التطبيق عند الفتح**

**الحل:**
```
1. تحقق من أذونات الكاميرا والمعرض
2. أعد تثبيت التطبيق
3. امسح ذاكرة التطبيق: Settings → Apps → مساعد يوهو VIP → Storage → Clear Cache
```

---

## 📝 **ملفات المشروع الأساسية**

```
📦 yoho-vip-assistant
├── 📂 app
│   ├── 📂 src/main
│   │   ├── 📂 java/com/yoho/vip/assistant
│   │   │   ├── 📄 MainActivity.kt          ⭐ الشاشة الرئيسية
│   │   │   ├── 📄 FloatingService.kt       ⭐ الزر العائم
│   │   │   └── 📄 FrameEditor.kt           ⭐ محرر الإطارات
│   │   ├── 📂 res/layout
│   │   │   ├── 📄 activity_main.xml        ⭐ التصميم الرئيسي
│   │   │   └── 📄 layout_floating.xml      ⭐ الزر العائم
│   │   ├── 📂 res/xml
│   │   │   └── 📄 file_paths.xml
│   │   └── 📄 AndroidManifest.xml          ⭐ الأذونات
│   └── 📄 build.gradle                     ⭐ الإعدادات
├── 📄 build.gradle                         ⭐ الإعدادات الرئيسية
├── 📄 settings.gradle
├── 📄 README.md                            📖 الدليل
└── 📄 RELEASE_NOTES.md                     📰 ملاحظات الإصدار
```

---

## 🎓 **دليل المبتدئين**

### إذا لم تكن تعرف البرمجة:

```
1. حمّل Android Studio
2. اتبع الخطوات 2-5 من "الطريقة 3" أعلاه
3. اضغط Run فقط
4. ستشتغل لاحقاً
```

### إذا كنت مبرمج:

```
1. Clone من GitHub
2. افتح build.gradle
3. عدّل ما تريد
4. اضغط Run
```

---

## 🚀 **الخطوة التالية**

✅ **بعد التحميل والتثبيت:**

1. افتح التطبيق
2. اختر صورة
3. أضف اسمك
4. اختر إطار
5. احفظ الصورة

**استمتع! 👑✨**

---

## 📞 **للمساعدة:**

- GitHub Issues: https://github.com/amynzby06-hue/yoho-vip-assistant/issues
- README: https://github.com/amynzby06-hue/yoho-vip-assistant/blob/main/README.md

---

**آخر تحديث:** 22 أغسط�� 2026  
**الحالة:** ✅ جاهز الآن!
