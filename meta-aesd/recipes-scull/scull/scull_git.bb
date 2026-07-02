# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
#
# The following license files were not able to be identified and are
# represented as "Unknown" below, you will need to check them yourself:
#   LICENSE
inherit module update-rc.d
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

SRC_URI = "git://github.com/kygm02/UColorado_Assignment_7_ldd3.git;protocol=https;branch=main \
           file://0001-fix-build-only-scull-and-misc-modules.patch \
           file://scull-load \
           "

# Modify these as desired
PV = "1.0+git"
SRCREV = "8ecc5634c9751279177655ad886920db1fdf95aa"

S = "${WORKDIR}/git"

EXTRA_OEMAKE += " -C ${STAGING_KERNEL_DIR} M=${S}/scull"

INITSCRIPT_NAME = "scull-load"
INITSCRIPT_PARAMS = "defaults 90"

FILES:${PN} += "${sysconfdir}"

do_install:append() {
    install -d ${D}${sysconfdir}/init.d
    install -m 0755 ${WORKDIR}/scull-load ${D}${sysconfdir}/init.d/scull-load
}

