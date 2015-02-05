DESCRIPTION = "Test Ada layer - Simple library in Ada"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
PR = "r6"
PROVIDES = "libhello"

SRC_URI = "file://libhello.ads file://libhello.adb file://LibHello.gpr file://yocto.cgpr"

#GPR_PROJECT_PATH .= ":${D}${libdir}/ada/${PN}"

# Install the files as:
#
# /usr/lib/ada/libhello/adainclude/libhello.ads
# /usr/lib/ada/libhello/adalib/libhello.ali
# /usr/lib/ada/libhello/libhello.gpr
# /usr/lib/libhello.a
# /usr/lib/libhello.so

FILES_${PN} = "${prefix}/share/gpr/* ${prefix}/lib/${PN}"

# FILES_${PN}-dev = "${libdir}/ada/${PN}/adalib/*.ali ${libdir}/ada/${PN}/adainclude/* ${libdir}/ada/${PN}/*.gpr"
# FILES_${PN}-staticdev = "${libdir}/ada/${PN}/adalib/*.a"

#FILES_${PN}-dbg = "${bindir}/.debug/*"

S = "${WORKDIR}"

export GPR_PROJECT_PATH = "${STAGING_DIR_TARGET}/usr/share/gpr/"

do_compile() {
	gprbuild -p -PLibHello.gpr --target=`echo ${TARGET_PREFIX} | sed 's/-$//' ` --config=./yocto.cgpr
}

do_install() {
        gprinstall -p -PLibHello.gpr --prefix=${D}/${prefix}
}

do_clean() {
	gprclean -PLibHello.gpr
}
