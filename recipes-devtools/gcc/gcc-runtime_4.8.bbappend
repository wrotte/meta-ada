RUNTIMETARGET += "libada"

PACKAGES += " \
  libada \
  libada-dev \
"

FILES_libada = "\
  ${libdir}/gcc/${TARGET_SYS}/${BINV}/adalib \
"

FILES_libada-dev = "\
  ${libdir}/gcc/${TARGET_SYS}/${BINV}/adainclude \
"
