# WARN
# Jangan merubah file ini
{
  pkgs ? import <nixpkgs> { },
}:

pkgs.mkShellNoCC {
  packages = with pkgs; [
    cowsay
    lolcat
    gradle
    tlrc
  ];
  shellHook = ''
    clear
    echo "Masuk kedalam nix-shell"| cowsay | lolcat
  '';
}
