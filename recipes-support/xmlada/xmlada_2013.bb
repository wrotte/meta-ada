DESCRIPTION = "XML Parsing facilities for Ada"
PROVIDES = "xmlada"
SECTION = "libs"
SRC_URI = "http://mirrors.cdn.adacore.com/art/85a4b23f00dbeec4a598b44f7595d260da1061b6;downloadfilename=xmlada-gpl-2013-src.tgz" 
SRC_URI += "file://install-fix.patch"
SRC_URI += "file://disable_docs_target.patch"
SRC_URI += "file://use_proper_gnat.patch"
SRC_URI[md5sum] = "46df8b0190af7e6950f824a55c00fd85"
SRC_URI[sha256sum] = "0c384ab84446fa8fbab1c6ca411ff789d73bb72d68373d1db60b7592ba1acff7"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM="file://COPYING3;md5=d32239bcb673463ab874e80d47fae504"

PARALLEL_MAKE = ""

PR="r14"

S = "${WORKDIR}/${BPN}-gpl-${PV}-src"
#S = "${WORKDIR}"

FILES_${PN} += "/usr/share/gps/plug-ins/xmlada_gps.py"
FILES_${PN}-dev += "/usr/lib/gnat/*.gpr /usr/lib/gnat/xmlada/*.lgpr usr/lib/xmlada/relocatable/*.so"
FILES_${PN}-staticdev += "${libdir}/xmlada/static/*.a"

inherit autotools 

EXTRA_OECONF += " --program-prefix '${TARGET_PREFIX}' --disable-shared "
BBCLASSEXTEND = "native nativesdk"

do_configure_prepend() {
   mv aclocal.m4 xmlada.m4
}
do_install_prepend() {
    oe_runmake 'DESTDIR=${D}' install_dirs
}

