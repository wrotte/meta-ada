DESCRIPTION = "XML Parsing facilities for Ada"
PROVIDES = "xmlada"
SECTION = "libs"
SRC_URI = "http://mirrors.cdn.adacore.com/art/065e0e6750288d9ecc2f7780d3ed8ef3c86ab991;downloadfilename=xmlada-gpl-2014-src.tgz" 
SRC_URI += "file://install-fix.patch"
SRC_URI[md5sum] = "1aaa49885ec280a3242823f659460dff"
SRC_URI[sha256sum] = "f686bc49318583c0a3bd12315e0ac8fcb3721bb8d528cdbf3bccbd753d227e69"
LICENSE = "GPLv2"

LIC_FILES_CHKSUM="file://README;beginline=267;endline=273;md5=d41d8cd98f00b204e9800998ecf8427e"

PARALLEL_MAKE = ""

PR="r8"

S = "${WORKDIR}/${BPN}-${PV}-src"
#S = "${WORKDIR}"

FILES_${PN} += "/usr/share/gps/plug-ins/xmlada_gps.py"
FILES_${PN}-dev += "/usr/lib/gnat/*.gpr /usr/lib/gnat/xmlada/*.lgpr usr/lib/xmlada/relocatable/*.so"
FILES_${PN}-staticdev += "${libdir}/xmlada/static/*.a"

inherit autotools 

EXTRA_AUTORECONF += "--exclude=aclocal"

BBCLASSEXTEND = "native nativesdk"

do_install() {
    oe_runmake 'DESTDIR=${D}' install_dirs
    oe_runmake 'DESTDIR=${D}' install
}

