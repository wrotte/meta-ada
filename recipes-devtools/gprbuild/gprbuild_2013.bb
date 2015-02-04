DESCRIPTION = "XML Parsing facilities for Ada"
PROVIDES = "gprbuild"
SECTION = "libs"
SRC_URI = "http://mirrors.cdn.adacore.com/art/7af1a92840a7c9b9c53335ebea8716526e31746b;downloadfilename=gprbuild-gpl-2013-src.tgz" 
SRC_URI += "file://fix_aclocal.patch"
SRC_URI += "file://use_proper_gnatmake.patch"
SRC_URI += "file://fix_install.patch"
SRC_URI[md5sum] = "f97cfb8b1dba3a10a9de1ef4d71117f8"
SRC_URI[sha256sum] = "7492347462d0a11a3672397a991ce3741347def3a468f850a91a54dfd4349144"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM="file://COPYING3;md5=d32239bcb673463ab874e80d47fae504"
PARALLEL_MAKE = ""

PR="r6"

S = "${WORKDIR}/${BPN}-${PV}-src"
export ADA_PROJECT_PATH = "${STAGING_DIR_TARGET}/usr/lib/gnat"
inherit autotools

EXTRA_OECONF += " --program-prefix ${TARGET_PREFIX} "

BBCLASSEXTEND = "native nativesdk"

FILES_${PN} += "/usr/share/examples/gprbuild/* /usr/share/gprconfig/* /usr/share/gpr/*"
FILES_${PN}-dbg += "/usr/lib/gprbuild/gprbuild/.debug/*"

do_configure_prepend() {
    mv aclocal.m4 gprbuild.m4                      
}
# do_install_prepend() {
#     oe_runmake 'DESTDIR=${D}' install_dirs
# }
