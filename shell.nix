# WARN
# Jangan merubah file ini
{
  pkgs ? import <nixpkgs> { },
}:

pkgs.mkShellNoCC {
  nativeBuildInputs = with pkgs; [
    gradle
    tlrc
  ];
}
