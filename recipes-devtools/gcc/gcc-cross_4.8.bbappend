require gcc-ada.inc

do_compile_prepend() {
  ln -sf  ${B}/gcc/config ${B}/gcc/ada/config  | true
  ln -sf  ${B}/gcc/config ${B}/gcc/ada/rts/config | true
  ln -sf  ${B}/gcc/config ${B}/gcc/ada/tools/config | true
}
