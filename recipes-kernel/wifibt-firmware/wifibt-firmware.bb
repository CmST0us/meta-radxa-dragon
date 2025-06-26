# Copyright (c) 2025 Radxa Computer (Shenzhen) Co., Ltd.

SUMMARY = "WIFI/BT firmware files"
SECTION = "kernel"

LICENSE = "BSD-3-Clause-Clear"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/${LICENSE};md5=7a434440b651f4a472ca93716d01033a"

SRCREV = "4c7ba27cf3306fd6531e1cef3146adfd383b0cba"
SRC_URI = "git://github.com/radxa/rkwifibt.git;protocol=https;branch=develop;"

S = "${WORKDIR}/git"

inherit allarch deploy

do_install() {
	install -d ${D}/${nonarch_base_libdir}/firmware/aic8800D80/

	cp -r ${S}/firmware/aic/usb/aic8800D80/* \
		${D}/${nonarch_base_libdir}/firmware/aic8800D80/
}

PACKAGES =+ " \
	${PN}-aic8800d80-usb \
"

FILES:${PN}-aic8800d80-usb = " \
	${nonarch_base_libdir}/firmware/aic8800D80/aic_powerlimit_8800d80.txt \
	${nonarch_base_libdir}/firmware/aic8800D80/aic_userconfig_8800d80.txt \
	${nonarch_base_libdir}/firmware/aic8800D80/calibmode_8800d80.bin \
	${nonarch_base_libdir}/firmware/aic8800D80/fmacfw_8800d80_h_u02.bin \
	${nonarch_base_libdir}/firmware/aic8800D80/fmacfw_8800d80_h_u02_ipc.bin \
	${nonarch_base_libdir}/firmware/aic8800D80/fmacfw_8800d80_u02.bin \
	${nonarch_base_libdir}/firmware/aic8800D80/fmacfw_8800d80_u02_ipc.bin \
	${nonarch_base_libdir}/firmware/aic8800D80/fw_adid_8800d80_u02.bin \
	${nonarch_base_libdir}/firmware/aic8800D80/fw_ble_scan_ad_filter.bin \
	${nonarch_base_libdir}/firmware/aic8800D80/fw_patch_8800d80_u02.bin \
	${nonarch_base_libdir}/firmware/aic8800D80/fw_patch_8800d80_u02_ext0.bin \
	${nonarch_base_libdir}/firmware/aic8800D80/fw_patch_table_8800d80_u02.bin \
	${nonarch_base_libdir}/firmware/aic8800D80/lmacfw_rf_8800d80_u02.bin \
"

FILES:${PN} = "*"

# Make it depend on all of the split-out packages.
python () {
    pn = d.getVar('PN')
    firmware_pkgs = oe.utils.packages_filter_out_system(d)
    d.appendVar('RDEPENDS:' + pn, ' ' + ' '.join(firmware_pkgs))
}

INSANE_SKIP:${PN}:append = " arch"
