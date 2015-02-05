DESCRIPTION = "Test Ada layer - Simple hello, world application in Ada"
SECTION = "examples"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
DEPENDS = "libhello"
PR = "r2"

SRC_URI = "file://hello.adb file://hello.gpr file://yocto.cgpr"

S = "${WORKDIR}"

export GPR_PROJECT_PATH = "${STAGING_DIR_TARGET}/usr/share/gpr/"

FILES_${PN} += "/usr/share/gpr"

do_compile() {
	gprbuild -p -Phello.gpr --config=./yocto.cgpr --target=`echo ${TARGET_PREFIX} | sed 's/-$//' `
}

do_install() {
        gprinstall -p -Phello.gpr --prefix=${D}/${prefix}
}

do_clean() {
	gprclean -Phello.gpr
}
