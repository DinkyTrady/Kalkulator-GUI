# WARN
# Jangan merubah file ini
{
  pkgs ? import <nixpkgs> { },
}:

pkgs.mkShell {
  nativeBuildInputs = with pkgs; [
    gradle
    tlrc
  ];
}
