# prog-log-reg — Jetpack Compose (Registrasi, Login, Profil, Avatar)

Android assignment: 4 screens in Kotlin + Jetpack Compose + Material3.

## Run

```bash
./gradlew :app:assembleDebug
# install app-debug.apk on emulator, flow:
# Login <-> Register (Save) -> Profile (Logout) -> Avatar
```

## Avatar mapping (precise)

Resources live in `app/src/main/res/drawable/` (moved from misplaced `app/drawable/`):

| File | Size | Layer |
|---|---|---|
| `face_0004.png` | 911×1293 | Base face+hair (no features) |
| `face_0001.png` | 597×59 | Brow |
| `face_0003.png` | 601×174 | Eye |
| `face_0002.png` | 181×126 | Nose |
| `face_0000.png` | 237×131 | Mouth |

`AvatarScreen.kt` uses `Box(contentAlignment=Center)`:
base `fillMaxSize(Fit)` first, then conditional overlays with
`fillMaxWidth(fraction) + aspectRatio(native) + offset(y)` tuned to the
`AvatarApp` screenshot (pink TopBar `#E91E63`, bg `#FDECEF`, orange
checkboxes default checked).

## Structure

```
MainActivity.kt (viewModels SessionViewModel -> NavGraph)
model/User.kt (8 fields) + SessionViewModel.kt (register/login/logout)
navigation/Routes.kt + NavGraph.kt (login/register/profile/avatar)
ui/theme/ (Pink theme)
screens/RegisterScreen.kt / LoginScreen.kt / ProfileScreen.kt / AvatarScreen.kt
```

Register: First/Last, Username, Email, Password+Confirm (blinded+toggle),
Phone, Address, BirthDate (DatePicker), validation, Save.
Login: Username+blinded Password, Login, Lupa Password Snackbar.
Profile: all Register fields, Logout (popUpTo login), link Avatar.

## Workflow

JIT issues, one branch per issue, squash to `main`, `Closes #N`:

1. Foundation (#1/#2) — Compose setup, drawable fix, skeleton
2. Domain (#3/#4) — User + ViewModel
3. Register (#5/#6)
4. Login (#7/#8)
5. Profile (#9/#10)
6. Avatar (#11/#12)
7. Polish (#13)
