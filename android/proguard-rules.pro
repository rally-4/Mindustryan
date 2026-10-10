-dontoptimize
-dontobfuscate

-keep class mindustry.** { *; }
-keep class mindustry.annotations.Annotations* { *; }
-keep class arc.** { *; }
-keep class net.jpountz.** { *; }
-keep class rhino.** { *; }
-keep class com.android.dex.** { *; }
-keep class com.android.dx.** { *; }
-keepattributes Signature,*Annotation*,InnerClasses,EnclosingMethod

-dontwarn javax.naming.**

#-printusage out.txt
