require gcc-ada.inc

do_compile_prepend() {
  pwd
  echo ${B}
  mkdir -p ${B}/gcc/ada/rts
  mkdir -p ${B}/gcc/ada/tools
  ln -sf  ${B}/gcc/config ${B}/gcc/ada/config  | true
  ln -sf  ${B}/gcc/config ${B}/gcc/ada/rts/config | true
  ln -sf  ${B}/gcc/config ${B}/gcc/ada/tools/config | true
}
