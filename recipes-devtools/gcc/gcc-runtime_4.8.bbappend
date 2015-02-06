RUNTIMETARGET += "libada"

EXTRA_OEMAKE += "AR_FOR_TARGET=${TARGET_PREFIX}ar RANLIB_FOR_TARGET=${TARGET_PREFIX}ranlib"

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
