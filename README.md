> **WARNING** Jangan edit file `shell.nix` dan `merge`

# Aplikasi java gui Ticket parkir

## Cara clone repo

```bash
# Clone kedirectory/folder mana aja
git clone --depth=1 https://github.com/DinkyTrady/ProjekPemDas

# Pindah kedirectory/folder tadi misal:
cd ./ProjekPemDas

# Lakuin pull biar main branch tetap up-to-date
git pull origin main

# Pindah kebranch `Sesuai nama`
git checkout "nama kalian"
# Contoh
git checkout randy

```

## Cara commit repo dan hal lain

setelah melakukan edit file dan ingin commit kemudian push

> [!WARNING]
> Jika gunakan titik "." maka akan menambahkan semua file yang sudah diedit
> git add "nama file" atau gunakan "."

- `git add "nama file atau ."`
- `git commit -m "<pesan berisi kenapa file diedit>"`
- `git push origin "nama branch"`

## Lakukan pull request lewat github

Buka repository ProjekPemDas pilih `pull request` pilih `create pull request`

## merge "nama branch kalian dengan main branch"

sebagai contoh branch randy akan lakuin merge

```bash
# pindah ke branch main
git switch main
# lakuin update pada branch main
git pull origin main

# pindah kebranch randy
git switch randy
# lakuin merge
git merge main

# Add semua file yang berubah !WARNING
git add .
# Lakukan commit
git commit -m "Lakuin merge dengan main branch agar tidak tertinggal"
# Push ke github
git push origin randy
```
