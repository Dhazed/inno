package it.infocert.demoportal.common.exception;


public class DemoPortalException extends Exception {

  private static final long serialVersionUID = 1L;

  /** Invalid parameters found */
  public static String ERROR_CODE_INVALID_PARAM = "GENE-0001";
  /** Entity/data not found */
  public static String ERROR_CODE_NOT_FOUND = "GENE-0101";
  /** Error generation key PKBox */
  public static String ERROR_CODE_GEN_KEY = "GENE-0105";
  /** Error generation p10 in PKBox */
  public static String ERROR_CODE_GEN_P10 = "GENE-0106";
  /** Error generation p10 in PKBox */
  public static String ERROR_CODE_IMP_CERT = "GENE-0107";
  /** Error persisting some entity/data */
  public static String ERROR_CODE_PERSIST = "GENE-0102";
  /** Object status */
  public static String ERROR_CODE_INVALID_STATUS = "GENE-0103";

  /** Error persisting some entity/data */
  public static String ERROR_CODE_CONNECTION = "GENE-0201";
  /** Error persisting Certificate because of duplicated key */
  public static String ERROR_CODE_DUPLICATED_KEY = "GENE-0104";

  /** Generic error from CA */
  public static String ERROR_CODE_CA_GEN = "EMCA-0001";

  /** Error generating SCIC */
  public static String ERROR_CODE_GEN_SCIC = "EMCA-0002";

  /** Error generating PKCS12 */
  public static String ERROR_CODE_GEN_PKCS12 = "GENE-0108";
  /** Error sending mail */
  public static String ERROR_CODE_MAIL = "GENE-0109";

  /** Domain Validation Error */
  public static String ERROR_INVALID_DOMAIN = "GENE-0110";

  /** Organization Validation Error */
  public static String ERROR_INVALID_ORGANIZATION = "GENE-0111";

  private String code;

  public DemoPortalException() {
    super();
  }

  public DemoPortalException(String cc, String msg, Throwable th) {
    super(msg, th);
    code = cc;
  }

  public DemoPortalException(String cc, String msg) {
    super(msg);
    code = cc;
  }

  public String getCode() {
    return code;
  }
}
